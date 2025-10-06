import {
  createRouter,
  RouterProvider as TanstackRouterProvider,
  createRootRoute,
  Outlet,
} from "@tanstack/react-router";
import { TanStackRouterDevtools } from "@tanstack/react-router-devtools";
import { Home, NotFound } from "@/app/routes";

const Root = createRootRoute({
  component: () => {
    return (
      <>
        <Outlet />
        <TanStackRouterDevtools />
      </>
    );
  },
  notFoundComponent: NotFound,
});
const routeTree = Root.addChildren([Home]);

const router = createRouter({
  routeTree,
});

declare module "@tanstack/react-router" {
  interface Register {
    router: typeof router;
  }
}

function RouterProvider() {
  return <TanstackRouterProvider router={router} />;
}

export default RouterProvider;
export { Root };
