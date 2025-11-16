import Button from '@/components/ui/button';
import Spinner from '@/components/ui/spinner';
import UserAvatar from '@/features/user/components/UserAvatar';
import type { SearchResultsAcceptFriendRequestMutation } from '@generated/relay/SearchResultsAcceptFriendRequestMutation.graphql';
import type { SearchResultsFragment$key } from '@generated/relay/SearchResultsFragment.graphql';
import type { SearchResultsRejectFriendRequestMutation } from '@generated/relay/SearchResultsRejectFriendRequestMutation.graphql';
import type { SearchResultsSendFriendRequestMutation } from '@generated/relay/SearchResultsSendFriendRequestMutation.graphql';
import { useFragment, useMutation } from 'react-relay';
import { graphql } from 'relay-runtime';

const SearchResultsFragment = graphql`
  fragment SearchResultsFragment on User {
    id
    email
    viewerRelation {
      status
    }
  }
`;

interface SearchResultsProps {
  results: SearchResultsFragment$key;
}

function SearchResults({ results }: SearchResultsProps) {
  const data = useFragment(SearchResultsFragment, results);

  const [sendFriendRequest] =
    useMutation<SearchResultsSendFriendRequestMutation>(graphql`
      mutation SearchResultsSendFriendRequestMutation($id: ID!) {
        sendFriendRequest(input: { friendId: $id })
      }
    `);

  const [rejectFriendRequest] =
    useMutation<SearchResultsRejectFriendRequestMutation>(graphql`
      mutation SearchResultsRejectFriendRequestMutation($id: ID!) {
        rejectFriendRequest(input: { friendId: $id })
      }
    `);

  const [acceptFriendRequest] =
    useMutation<SearchResultsAcceptFriendRequestMutation>(graphql`
      mutation SearchResultsAcceptFriendRequestMutation($id: ID!) {
        acceptFriendRequest(input: { friendId: $id })
      }
    `);

  return (
    <div
      key={data.id}
      className='p-2 flex items-center justify-between border-b border-border'
    >
      <div className='flex items-center'>
        <UserAvatar />
        {data.email}
      </div>

      <div>
        {data.viewerRelation.status === 'FRIENDS' && (
          <Button variant='icon' icon='already-friends' />
        )}

        {data.viewerRelation.status === 'REQUEST_PENDING' && (
          <div className='flex'>
            <Button
              variant='icon'
              icon='add-friend'
              onClick={() => {
                acceptFriendRequest({
                  variables: {
                    id: data.id,
                  },
                });
              }}
            />
            <Button
              variant='icon'
              icon='x'
              onClick={() => {
                rejectFriendRequest({
                  variables: {
                    id: data.id,
                  },
                });
              }}
            />
          </div>
        )}

        {data.viewerRelation.status === 'NOT_FRIENDS' && (
          <Button
            variant='icon'
            icon='add-friend'
            onClick={() => {
              sendFriendRequest({
                variables: {
                  id: data.id,
                },
              });
            }}
          />
        )}
      </div>
    </div>
  );
}

export default SearchResults;
