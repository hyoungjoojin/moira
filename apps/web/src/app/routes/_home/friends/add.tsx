import Button from '@/components/ui/button';
import Input from '@/components/ui/input';
import RequestList from '@/features/friend/components/RequestList';
import { ArrowLeft, Search } from '@mynaui/icons-react';
import { createFileRoute, useNavigate } from '@tanstack/react-router';

export const Route = createFileRoute('/_home/friends/add')({
  component: RouteComponent,
});

function RouteComponent() {
  const navigate = useNavigate();

  return (
    <>
      <title>moira - Add Friends</title>

      <main>
        <div className='flex items-center justify-between'>
          <div className='flex items-center justify-center'>
            <Button
              variant='icon'
              icon={<ArrowLeft />}
              onClick={() => {
                navigate({ to: '/friends' });
              }}
            />

            <h2 className='text-xl font-bold'>Add Friends</h2>
          </div>
        </div>

        <div className='py-4'>
          <Input icon={<Search />} />
        </div>

        <RequestList />
      </main>
    </>
  );
}
