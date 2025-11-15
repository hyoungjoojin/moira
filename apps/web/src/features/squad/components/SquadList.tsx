import { useAuth } from '@/store/auth';
import type { SquadListQuery } from '@generated/relay/SquadListQuery.graphql';
import { useNavigate } from '@tanstack/react-router';
import { graphql, useLazyLoadQuery } from 'react-relay';

function SquadList() {
  const { user } = useAuth();

  const data = useLazyLoadQuery<SquadListQuery>(
    graphql`
      query SquadListQuery($id: ID!) {
        user(id: $id) {
          squads {
            id
            name
          }
        }
      }
    `,
    {
      id: user!.id,
    },
  );

  if (!data.user) {
    return null;
  }

  const { squads } = data.user;

  return (
    <div className='flex flex-col h-full'>
      <div className='flex-1 overflow-y-auto p-4 space-y-3'>
        {squads
          .filter((squad) => !!squad)
          .map((squad) => (
            <SquadListItem key={squad!.id} id={squad!.id} name={squad!.name} />
          ))}
      </div>
    </div>
  );
}

interface SquadListItemProps {
  id: string;
  name: string;
}

function SquadListItem({ id, name }: SquadListItemProps) {
  const navigate = useNavigate();

  return (
    <div
      className='group bg-gradient-to-br from-white to-slate-50 dark:from-slate-700 dark:to-slate-800 rounded-2xl p-4 shadow-md hover:shadow-xl transition-all duration-300 cursor-pointer border border-slate-200 dark:border-slate-600'
      onClick={() => navigate({ to: `/squads/${id}` })}
    >
      {name}
    </div>
  );
}

export default SquadList;
