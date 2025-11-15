import HomeLayout from '@/components/layouts/home';
import { useAuth } from '@/store/auth';
import { Outlet, createFileRoute, useNavigate } from '@tanstack/react-router';

export const Route = createFileRoute('/_home')({
  component: Home,
});

function Home() {
  const navigate = useNavigate();
  const { user } = useAuth();
  if (!user) {
    navigate({ to: '/auth/login' });
  }

  return (
    <HomeLayout>
      <Outlet />
    </HomeLayout>
  );
}
