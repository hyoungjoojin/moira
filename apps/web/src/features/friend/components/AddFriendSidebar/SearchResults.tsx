import type { SearchResultsFragment$key } from '@generated/relay/SearchResultsFragment.graphql';
import { useFragment } from 'react-relay';
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

  return (
    <div key={data.id}>
      {data.email}

      <div>
        {data.viewerRelation.status === 'FRIENDS' && 'Already friends'}
        {data.viewerRelation.status === 'NOT_FRIENDS' && 'Add Friend'}
      </div>
    </div>
  );
}

export default SearchResults;
