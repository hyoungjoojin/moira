import type { FetchFunction } from "relay-runtime";

export const query: FetchFunction = async (request, variables) => {
  const response = await fetch("/", {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify({ query: request.text, variables }),
  });

  if (!response.ok) {
    throw new Error("request failed");
  }

  return await response.json();
};
