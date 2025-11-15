import { createFileRoute } from '@tanstack/react-router';

export const Route = createFileRoute('/_home/friends/')({
  component: Friends,
});

function Friends() {
  return (
    <>
      <title>moira - Friends</title>
    </>
  );
}
