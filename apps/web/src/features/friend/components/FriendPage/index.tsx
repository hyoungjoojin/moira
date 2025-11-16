import Button from '@/components/ui/button';
import Icon from '@/components/ui/icon';
import type { FriendPageUserQuery as FriendPageUserQueryType } from '@generated/relay/FriendPageUserQuery.graphql';
import { notFound } from '@tanstack/react-router';
import { useLazyLoadQuery } from 'react-relay';
import { graphql } from 'relay-runtime';

interface FriendPageProps {
  id: string;
}

const FriendPageUserQuery = graphql`
  query FriendPageUserQuery($id: ID!) {
    user(id: $id) {
      email
    }
  }
`;

function FriendPage({ id }: FriendPageProps) {
  const { user } = useLazyLoadQuery<FriendPageUserQueryType>(
    FriendPageUserQuery,
    {
      id,
    },
  );

  if (!user) {
    throw notFound();
  }

  return (
    <div>
      <div className='w-full flex items-center relative'>
        <div className='flex items-end w-full gap-2 p-5 bg-background-inverted/10'>
          <div className='bg-background-inverted/50 p-2 rounded-xl'>
            <Icon icon='user' size={200} />
          </div>

          <div className='flex flex-col gap-2 p-5'>
            <span className='text-3xl font-bold'>User Name</span>
            <span>{user.email}</span>
          </div>
        </div>

        <div className='absolute top-5 right-5 flex gap-2'>
          <Button variant='icon' icon='heart' />
          <Button variant='icon' icon='ellipsis' />
        </div>
      </div>

      <div></div>
    </div>
  );
}

export default FriendPage;
