import env from './env';
import type { FetchFunction } from 'relay-runtime';

const HTTP_ENDPOINT = env.VITE_MOIRA_SERVER_URL;

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

export default moira;
