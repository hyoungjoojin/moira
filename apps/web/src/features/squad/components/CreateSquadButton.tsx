import Button from '@/components/ui/button';
import { type CreateSquadButtonCreateSquadMutation } from '@generated/relay/CreateSquadButtonCreateSquadMutation.graphql';
import { Plus } from '@mynaui/icons-react';
import { graphql, useMutation } from 'react-relay';

function CreateSquadButton() {
  const [createSquad] = useMutation<CreateSquadButtonCreateSquadMutation>(
    graphql`
      mutation CreateSquadButtonCreateSquadMutation {
        createSquad(input: { name: "New Squad" }) {
          id
          name
        }
      }
    `,
  );

  return (
    <Button
      onClick={() => {
        createSquad({
          variables: {},
        });
      }}
      variant='icon'
      icon={<Plus />}
    />
  );
}

export default CreateSquadButton;
