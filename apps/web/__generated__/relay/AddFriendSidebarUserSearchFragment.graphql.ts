/**
 * @generated SignedSource<<4d85eae051482956af0535141ee7fcf2>>
 * @lightSyntaxTransform
 * @nogrep
 */

/* tslint:disable */
/* eslint-disable */
// @ts-nocheck

import { ReaderFragment } from 'relay-runtime';
import { FragmentRefs } from "relay-runtime";
export type AddFriendSidebarUserSearchFragment$data = {
  readonly search: {
    readonly nodes: ReadonlyArray<{
      readonly " $fragmentSpreads": FragmentRefs<"SearchResultsFragment">;
    }>;
  };
  readonly " $fragmentType": "AddFriendSidebarUserSearchFragment";
};
export type AddFriendSidebarUserSearchFragment$key = {
  readonly " $data"?: AddFriendSidebarUserSearchFragment$data;
  readonly " $fragmentSpreads": FragmentRefs<"AddFriendSidebarUserSearchFragment">;
};

import AddFriendSidebarUserSearchRefetchQuery_graphql from './AddFriendSidebarUserSearchRefetchQuery.graphql';

const node: ReaderFragment = {
  "argumentDefinitions": [
    {
      "defaultValue": null,
      "kind": "LocalArgument",
      "name": "query"
    }
  ],
  "kind": "Fragment",
  "metadata": {
    "refetch": {
      "connection": null,
      "fragmentPathInResult": [],
      "operation": AddFriendSidebarUserSearchRefetchQuery_graphql
    }
  },
  "name": "AddFriendSidebarUserSearchFragment",
  "selections": [
    {
      "alias": null,
      "args": [
        {
          "fields": [
            {
              "kind": "Literal",
              "name": "first",
              "value": 50
            },
            {
              "kind": "Variable",
              "name": "query",
              "variableName": "query"
            },
            {
              "kind": "Literal",
              "name": "type",
              "value": "USER"
            }
          ],
          "kind": "ObjectValue",
          "name": "input"
        }
      ],
      "concreteType": "SearchResultConnection",
      "kind": "LinkedField",
      "name": "search",
      "plural": false,
      "selections": [
        {
          "alias": null,
          "args": null,
          "concreteType": null,
          "kind": "LinkedField",
          "name": "nodes",
          "plural": true,
          "selections": [
            {
              "kind": "InlineFragment",
              "selections": [
                {
                  "args": null,
                  "kind": "FragmentSpread",
                  "name": "SearchResultsFragment"
                }
              ],
              "type": "User",
              "abstractKey": null
            }
          ],
          "storageKey": null
        }
      ],
      "storageKey": null
    }
  ],
  "type": "Query",
  "abstractKey": null
};

(node as any).hash = "46b8719377101f75ad2bc988924e8876";

export default node;
