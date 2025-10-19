import moira from '@/utils/server';
import { useMemo } from 'react';
import { RelayEnvironmentProvider } from 'react-relay';
import { Environment, Network } from 'relay-runtime';

interface RelayProviderProps {
  children: React.ReactNode;
}

function createEnvironment() {
  return new Environment({
    network: Network.create(moira),
  });
}

function RelayProvider({ children }: RelayProviderProps) {
  const environment = useMemo(() => createEnvironment(), []);

  return (
    <RelayEnvironmentProvider environment={environment}>
      {children}
    </RelayEnvironmentProvider>
  );
}

export default RelayProvider;
