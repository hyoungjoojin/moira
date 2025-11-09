import Button from '@/components/ui/button';
import type { RequestListAddFriendMutation } from '@generated/relay/RequestListAddFriendMutation.graphql';
import type { RequestListUsersQuery } from '@generated/relay/RequestListUsersQuery.graphql';
import { Plus } from '@mynaui/icons-react';
import { graphql, useLazyLoadQuery, useMutation } from 'react-relay';

function RequestList() {
  const { users } = useLazyLoadQuery<RequestListUsersQuery>(
    graphql`
      query RequestListUsersQuery {
        users {
          id
          email
        }
      }
    `,
    {},
  );

  const [sendFriendRequest, isPending] =
    useMutation<RequestListAddFriendMutation>(graphql`
      mutation RequestListAddFriendMutation($id: ID!) {
        sendFriendRequest(input: { friendId: $id })
      }
    `);

  return (
    <>
      {users.map((user, index) => {
        if (!user) {
          return null;
        }

        return (
          <div key={index} className='flex items-center justify-between p-2'>
            <div>{user.email}</div>

            <div>
              <Button
                isPending={isPending}
                variant='icon'
                icon={<Plus />}
                onClick={() => {
                  sendFriendRequest({
                    variables: {
                      id: user.id,
                    },
                  });
                }}
              />
            </div>
          </div>
        );
      })}
    </>
  );
}

export default RequestList;
