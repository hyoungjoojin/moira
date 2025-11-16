import SearchResults from './SearchResults';
import Button from '@/components/ui/button';
import Input from '@/components/ui/input';
import { useSidebar, useSidebarActions } from '@/store/sidebar';
import type { AddFriendSidebarUserSearchFragment$key } from '@generated/relay/AddFriendSidebarUserSearchFragment.graphql';
import type { AddFriendSidebarUserSearchRefetchQuery } from '@generated/relay/AddFriendSidebarUserSearchRefetchQuery.graphql';
import { useNavigate } from '@tanstack/react-router';
import { useDebounce } from '@uidotdev/usehooks';
import { useEffect, useState, useTransition } from 'react';
import { useRefetchableFragment } from 'react-relay';
import { graphql } from 'relay-runtime';

const AddFriendSidebarUserSearchFragment = graphql`
  fragment AddFriendSidebarUserSearchFragment on Query
  @refetchable(queryName: "AddFriendSidebarUserSearchRefetchQuery")
  @argumentDefinitions(query: { type: "String!" }) {
    search(input: { first: 50, query: $query, type: USER }) {
      nodes {
        ... on User {
          ...SearchResultsFragment
        }
      }
    }
  }
`;

function AddFriendSidebar() {
  const { open } = useSidebar();

  const [searchQuery, setSearchQuery] = useState('');
  const debouncedSearchQuery = useDebounce(searchQuery, 1000);

  const [pending, startTransition] = useTransition();

  const [data, refetch] = useRefetchableFragment<
    AddFriendSidebarUserSearchRefetchQuery,
    AddFriendSidebarUserSearchFragment$key
  >(AddFriendSidebarUserSearchFragment, null);

  useEffect(() => {
    if (debouncedSearchQuery !== '') {
      startTransition(() => {
        refetch({ query: debouncedSearchQuery });
      });
    }
  }, [debouncedSearchQuery, refetch, startTransition]);

  return (
    <div>
      <BackButton open={open} />

      <SearchButton
        open={open}
        value={searchQuery}
        onChange={(e) => {
          setSearchQuery(e.target.value);
        }}
        pending={pending}
      />

      {open &&
        data?.search.nodes.map((result, index) => {
          return <SearchResults key={index} results={result} />;
        })}
    </div>
  );
}

function BackButton({ open }: { open: boolean }) {
  const navigate = useNavigate();

  function backButtonClickHandler() {
    navigate({ to: '/friends' });
  }

  if (open) {
    return (
      <Button
        variant='ghost'
        icon='back'
        onClick={backButtonClickHandler}
        className={open ? 'self-start' : 'mx-auto'}
      >
        Back to friends
      </Button>
    );
  } else {
    return (
      <Button
        variant='icon'
        icon='back'
        onClick={backButtonClickHandler}
        className={open ? 'self-start' : 'mx-auto'}
      />
    );
  }
}

import React from 'react';

const SearchButton = React.memo(function SearchButton({
  open,
  value,
  onChange,
  pending,
}: {
  open: boolean;
  value: string;
  onChange: (e: React.ChangeEvent<HTMLInputElement>) => void;
  pending: boolean;
}) {
  const { openSidebar } = useSidebarActions();

  if (!open) {
    return <Button variant='icon' icon='search' onClick={openSidebar} />;
  }

  return (
    <Input
      icon='search'
      type='text'
      placeholder='Search friends'
      value={value}
      pending={pending}
      onChange={onChange}
    />
  );
});

export default AddFriendSidebar;
