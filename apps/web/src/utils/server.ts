import env from './env';
import { type ExecutionResult, type Sink, createClient } from 'graphql-ws';
import {
  type FetchFunction,
  type GraphQLResponse,
  Observable,
  type SubscribeFunction,
} from 'relay-runtime';
import type { RelayObservable } from 'relay-runtime/lib/network/RelayObservable';

const HTTP_ENDPOINT = env.VITE_MOIRA_SERVER_HTTP_URL;
const WS_ENDPOINT = env.VITE_MOIRA_SERVER_WS_URL;

const moira: FetchFunction = async (request, variables) => {
  const response = await fetch(HTTP_ENDPOINT, {
    method: 'POST',
    body: JSON.stringify({ query: request.text, variables }),
    headers: {
      'Content-Type': 'application/json',
    },
  });

  if (!response.ok) {
    throw new Error('Response failed');
  }

  return await response.json();
};

const wsClient = createClient({
  url: WS_ENDPOINT,
});

const ws: SubscribeFunction = (operation, variables) => {
  return Observable.create((sink: Sink<ExecutionResult<GraphQLResponse>>) => {
    if (!operation.text) {
      return sink.error(new Error('Operation text is missing'));
    }

    return wsClient.subscribe(
      {
        operationName: operation.name,
        query: operation.text,
        variables,
      },
      sink,
    );
  }) as RelayObservable<GraphQLResponse>;
};

export default moira;
export { ws };
