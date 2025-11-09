import LoginForm from '@/features/auth/login/components/LoginForm';
import { createFileRoute } from '@tanstack/react-router';

export const Route = createFileRoute('/auth/login')({
  component: Login,
});

function Login() {
  return (
    <>
      <title>moira - Login</title>

      <div>
        <LoginForm />
      </div>
    </>
  );
}
