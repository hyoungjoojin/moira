import { createFileRoute } from '@tanstack/react-router';

export const Route = createFileRoute('/_home/friends/add')({
  component: AddFriend,
});

function AddFriend() {
  return (
    <>
      <title>moira - Add Friends</title>
    </>
  );
}
