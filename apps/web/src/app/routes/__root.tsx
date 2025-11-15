import { Outlet, createRootRoute } from '@tanstack/react-router';
import { TanStackRouterDevtools } from '@tanstack/react-router-devtools';
import * as React from 'react';

export const Route = createRootRoute({
  component: Root,
  errorComponent: ({ error }) => <div>Error: {String(error)}</div>,
});

function Root() {
  return (
    <React.Fragment>
      <Outlet />
      <TanStackRouterDevtools position='bottom-right' />
    </React.Fragment>
  );
}
