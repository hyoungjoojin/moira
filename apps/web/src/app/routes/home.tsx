import { createRoute } from "@tanstack/react-router";
import { Root } from "@/app/providers/RouterProvider";

const Home = createRoute({
  getParentRoute: () => Root,
  path: "/",
  component: HomeComponent,
});

function HomeComponent() {
  return (
    <>
      <title>moira</title>
    </>
  );
}

export { Home };
