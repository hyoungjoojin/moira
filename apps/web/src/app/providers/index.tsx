import RelayProvider from "./RelayProvider";
import RouterProvider from "./RouterProvider";

function AppProvider() {
  return (
    <RelayProvider>
      <RouterProvider />
    </RelayProvider>
  );
}

export default AppProvider;
