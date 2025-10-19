import { createFileRoute } from "@tanstack/react-router";

export const Route = createFileRoute("/auth/login")({
  component: RouteComponent,
});

function RouteComponent() {
  return (
    <>
      <title>moira - Login</title>

      <div>login</div>
    </>
  );
}
