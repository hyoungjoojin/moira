import { routeTree } from '@generated/router/tree';
import {
  RouterProvider as TanstackRouterProvider,
  createRouter,
} from '@tanstack/react-router';

const router = createRouter({
  routeTree,
});

declare module '@tanstack/react-router' {
  interface Register {
    router: typeof router;
  }
}

function RouterProvider() {
  return <TanstackRouterProvider router={router} />;
}

export default RouterProvider;
