import FriendPage from '@/features/friend/components/FriendPage';
import { createFileRoute } from '@tanstack/react-router';

export const Route = createFileRoute('/_home/friends/$id')({
  component: Friend,
});

function Friend() {
  const { id } = Route.useParams();

  return <FriendPage id={id} />;
}
