import { Link, createFileRoute } from '@tanstack/react-router';

export const Route = createFileRoute('/')({
  component: RouteComponent,
});

function RouteComponent() {
  return (
    <>
      <title>moira</title>

      <div>
        <Link to='/auth/login'>Login</Link>
        <Link to='/auth/register'>Register</Link>
      </div>
    </>
  );
}
