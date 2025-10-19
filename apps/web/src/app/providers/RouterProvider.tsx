import {
  createRouter,
  RouterProvider as TanstackRouterProvider,
} from "@tanstack/react-router";
import { routeTree } from "../routes/routeTree.gen";

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
