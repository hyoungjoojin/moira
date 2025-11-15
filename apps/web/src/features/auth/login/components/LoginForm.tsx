import Button from '@/components/ui/button';
import { useAuthActions } from '@/store/auth';
import logger from '@/utils/logger';
import type { LoginFormLoginUserMutation } from '@generated/relay/LoginFormLoginUserMutation.graphql';
import { zodResolver } from '@hookform/resolvers/zod';
import { useNavigate } from '@tanstack/react-router';
import { useState } from 'react';
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
  const { setUser } = useAuthActions();

  const [showPassword, setShowPassword] = useState(false);
  const {
    register,
    formState: { errors },
    handleSubmit,
  } = useForm<LoginInput>({
    resolver: zodResolver(schema),
    defaultValues: {
      email: 'fuck',
      password: 'fuck',
    },
  });

  const [loginUser, isPending] = useMutation<LoginFormLoginUserMutation>(
    graphql`
      mutation LoginFormLoginUserMutation($input: LoginInput) {
        login(input: $input) {
          id
        }
      }
    `,
  );

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
        if (!response.login) {
          logger.error('Response does not contain login data');
          return;
        }

        setUser({
          id: response.login.id,
        });
        navigate({ to: '/friends' });
      },
      onError: (error) => {
        console.log(error);
      },
    });
  };

  return (
    <form
      onSubmit={handleSubmit(formSubmitHandler)}
      className='max-w-sm mx-auto p-6 bg-white rounded shadow sm:p-8 sm:max-w-md'
    >
      <div className='mb-4'>
        <label
          htmlFor='email'
          className='block text-sm font-medium text-gray-700 mb-1'
        >
          Email
        </label>
        <input
          id='email'
          type='text'
          placeholder='Enter your email'
          className='w-full px-3 py-2 border rounded focus:outline-none focus:ring focus:border-blue-300'
          {...register('email')}
        />
        {errors.email && (
          <span className='text-xs text-red-500 mt-1 block'>
            {errors.email.message}
          </span>
        )}
      </div>

      <div className='mb-6'>
        <label
          htmlFor='password'
          className='block text-sm font-medium text-gray-700 mb-1'
        >
          Password
        </label>
        <div className='relative'>
          <input
            id='password'
            type={showPassword ? 'text' : 'password'}
            placeholder='Enter your password'
            className='w-full px-3 py-2 border rounded focus:outline-none focus:ring focus:border-blue-300 pr-10'
            {...register('password')}
          />
          <button
            type='button'
            tabIndex={0}
            className='absolute right-2 top-2 text-xs text-gray-500 hover:text-gray-700 focus:outline-none'
            onClick={() => setShowPassword((prev) => !prev)}
            aria-label={showPassword ? 'Hide password' : 'Show password'}
          >
            {showPassword ? 'Hide' : 'Show'}
          </button>
        </div>
        {errors.password && (
          <span className='text-xs text-red-500 mt-1 block'>
            {errors.password.message}
          </span>
        )}
      </div>

      <div className='mb-4 text-right'>
        <a
          href='/auth/forgot-password'
          className='text-xs text-blue-600 hover:underline'
        >
          Forgot password?
        </a>
      </div>

      <Button isPending={isPending} disabled={isPending} className='w-full'>
        {isPending ? 'Logging in...' : 'Submit'}
      </Button>
    </form>
  );
}

export default LoginForm;
