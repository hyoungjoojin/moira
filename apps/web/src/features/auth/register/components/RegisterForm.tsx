import Button from '@/components/ui/button';
import type { RegisterFormRegisterUserMutation } from '@generated/relay/RegisterFormRegisterUserMutation.graphql';
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
type RegisterInput = z.infer<typeof schema>;

function RegisterForm() {
  const {
    register,
    formState: { errors },
    handleSubmit,
  } = useForm<RegisterInput>({
    resolver: zodResolver(schema),
    defaultValues: {
      email: '',
      password: '',
    },
  });

  const [registerUser, isPending] =
    useMutation<RegisterFormRegisterUserMutation>(graphql`
      mutation RegisterFormRegisterUserMutation($input: RegisterUserInput) {
        register(input: $input) {
          id
        }
      }
    `);

  const navigate = useNavigate({ from: '/auth/register' });

  const formSubmitHandler = (values: RegisterInput) => {
    registerUser({
      variables: {
        input: {
          email: values.email,
          password: values.password,
        },
      },
      onCompleted: (response) => {
        console.log(response);
        navigate({ to: '/auth/login' });
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

export default RegisterForm;
