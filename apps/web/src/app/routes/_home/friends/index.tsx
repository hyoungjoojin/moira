import Button from '@/components/ui/button';
import FriendList from '@/features/friend/components/FriendList';
import { Plus } from '@mynaui/icons-react';
import { createFileRoute, useNavigate } from '@tanstack/react-router';

export const Route = createFileRoute('/_home/friends/')({
  component: RouteComponent,
});

function RouteComponent() {
  const navigate = useNavigate();

  return (
    <>
      <title>moira - Friends</title>

      <main>
        <div className='flex items-center justify-between'>
          <h2 className='text-xl font-bold'>Friends</h2>

          <div>
            <Button
              onClick={() => {
                navigate({ to: '/friends/add' });
              }}
              variant='icon'
              icon={<Plus />}
            />
          </div>
        </div>

        <FriendList />
      </main>
    </>
  );
}
