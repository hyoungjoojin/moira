import Button from '@/components/ui/button';
import { zodResolver } from '@hookform/resolvers/zod';
import { useNavigate } from '@tanstack/react-router';
import { useForm } from 'react-hook-form';
import { useMutation } from 'react-relay';
import { graphql } from 'relay-runtime';
import { z } from 'zod';

const schema = z.object({
  email: z.string().nonempty({ message: 'email no empty' }),
  password: z.string().nonempty(),
});
type LoginInput = z.infer<typeof schema>;

function LoginForm() {
  const {
    register,
    formState: { errors },
    handleSubmit,
  } = useForm<LoginInput>({
    resolver: zodResolver(schema),
    defaultValues: {
      email: '',
      password: '',
    },
  });

  const [loginUser, isPending] = useMutation(graphql`
    mutation LoginFormLoginUserMutation($input: LoginInput) {
      login(input: $input) {
        id
      }
    }
  `);

  const navigate = useNavigate({ from: '/auth/login' });

  const formSubmitHandler = (values: LoginInput) => {
    loginUser({
      variables: {
        input: {
          email: values.email,
          password: values.password,
        },
      },
      onCompleted: (response) => {
        console.log(response);
        navigate({ to: '/' });
      },
      onError: (error) => {
        console.log(error);
      },
    });
  };

  return (
    <form onSubmit={handleSubmit(formSubmitHandler)}>
      <div>
        <label>Email</label>
        <input type='text' {...register('email')} />
        {errors.email && errors.email.message}
      </div>

      <div>
        <label>Password</label>
        <input type='password' {...register('password')} />
        {errors.password && errors.password.message}
      </div>

      <Button isPending={isPending}>Submit</Button>
    </form>
  );
}

export default LoginForm;
