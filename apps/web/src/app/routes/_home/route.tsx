import HomeLayout from '@/components/layouts/home';
import { Outlet, createFileRoute } from '@tanstack/react-router';

export const Route = createFileRoute('/_home')({
  component: RouteComponent,
});

function RouteComponent() {
  return (
    <HomeLayout>
      <Outlet />
    </HomeLayout>
  );
}
