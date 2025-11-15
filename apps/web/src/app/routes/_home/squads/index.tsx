import CreateSquadButton from '@/features/squad/components/CreateSquadButton';
import SquadList from '@/features/squad/components/SquadList';
import { createFileRoute } from '@tanstack/react-router';

export const Route = createFileRoute('/_home/squads/')({
  component: RouteComponent,
});

function RouteComponent() {
  return (
    <>
      <title>moira - Squads</title>

      <main>
        <div className='flex items-center justify-between'>
          <h2 className='text-xl font-bold'>Squads</h2>

          <div>
            <CreateSquadButton />
          </div>
        </div>

        <SquadList />
      </main>
    </>
  );
}
