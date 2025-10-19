import { createFileRoute } from "@tanstack/react-router";

export const Route = createFileRoute("/auth/register")({
  component: RouteComponent,
});

function RouteComponent() {
  return (
    <>
      <title>moira - Register</title>

      <div>Register</div>
    </>
  );
}
