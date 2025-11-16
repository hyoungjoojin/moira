import UserAvatar from '@/features/user/components/UserAvatar';
import { cn } from '@/utils/cn';
import type { FriendListQuery as FriendListQueryType } from '@generated/relay/FriendListQuery.graphql';
import { useNavigate } from '@tanstack/react-router';
import { useLazyLoadQuery } from 'react-relay';
import { graphql } from 'relay-runtime';

const FriendListQuery = graphql`
  query FriendListQuery {
    viewer {
      friends {
        nodes {
          rightUser {
            id
            email
          }
        }
      }
    }
  }
`;

function FriendList() {
  const data = useLazyLoadQuery<FriendListQueryType>(FriendListQuery, {});
  return (
    <>
      {data.viewer.friends.nodes.map((friend) => (
        <FriendListItem key={friend.rightUser.id} {...friend.rightUser} />
      ))}
    </>
  );
}

interface FriendListItemProps {
  id: string;
  email: string;
}

function FriendListItem({ id, email }: FriendListItemProps) {
  const navigate = useNavigate();

  return (
    <div
      className={cn(
        'rounded-md p-2',
        'flex items-center gap-2',
        'hover:bg-background-inverted/5 hover:cursor-pointer',
      )}
      onClick={() => {
        navigate({ to: '/friends/$id', params: { id } });
      }}
    >
      <UserAvatar />
      {email}
    </div>
  );
}

export default FriendList;
