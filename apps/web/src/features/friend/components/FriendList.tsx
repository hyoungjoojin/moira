import Button from '@/components/ui/button';
import { cn } from '@/utils/cn';
import type { FriendListQuery } from '@generated/relay/FriendListQuery.graphql';
import { Chat } from '@mynaui/icons-react';
import { graphql, useLazyLoadQuery } from 'react-relay';

function FriendList() {
  const {
    me: { friends },
  } = useLazyLoadQuery<FriendListQuery>(
    graphql`
      query FriendListQuery($first: Int = 10, $after: String) {
        me {
          friends(first: $first, after: $after) {
            nodes {
              id
              email
            }
          }
        }
      }
    `,
    {},
  );

  return (
    <>
      <div className='flex items-center justify-between'>
        <span className='text-sm font-bold'>Friends</span>
        <span>
          <Button variant='icon' icon='filter' />
        </span>
      </div>

      {friends.nodes.map((node, index) => (
        <FriendListItem key={index} {...node} />
      ))}
    </>
  );
}
interface FriendListItemProps {
  id: string;
  email: string;
}

function FriendListItem({ id, email }: FriendListItemProps) {
  return (
    <div
      className={cn(
        'p-4 flex items-center justify-between rounded-lg mb-2',
        'hover:bg-slate-50 cursor-pointer transition-colors',
      )}
    >
      <div className='relative flex items-center gap-4'>
        <div className='w-10 h-10 rounded-full border flex items-center justify-center text-2xl shadow-md' />

        <div className='flex flex-col'>
          <span className='font-bold'>{email}</span>
          <span>{id}</span>
        </div>
      </div>

      <div>
        <Button variant='icon' icon={<Chat />} />
      </div>
    </div>
  );
}

export default FriendList;
