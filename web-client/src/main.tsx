import { StrictMode, Suspense } from "react";
import { createRoot } from "react-dom/client";
import App from "./components/App";
import { Environment, Network } from "relay-runtime";
import { query } from "./util/server.ts";
import { RelayEnvironmentProvider } from "react-relay";

import "./styles/globals.css";

const relayEnvironment = new Environment({
  network: Network.create(query),
});

createRoot(document.getElementById("root")!).render(
  <StrictMode>
    <RelayEnvironmentProvider environment={relayEnvironment}>
      <Suspense fallback="Loading...">
        <App />
      </Suspense>
    </RelayEnvironmentProvider>
  </StrictMode>,
);
