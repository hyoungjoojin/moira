import type { FriendListQuery as FriendListQueryType } from '@generated/relay/FriendListQuery.graphql';
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
        <div key={friend.rightUser.id}>{friend.rightUser.email}</div>
      ))}
    </>
  );
}

export default FriendList;
