/**
 * @generated SignedSource<<60fd7616e773ab89b3b30fb8ddbdf126>>
 * @lightSyntaxTransform
 * @nogrep
 */

/* tslint:disable */
/* eslint-disable */
// @ts-nocheck

import { ConcreteRequest } from 'relay-runtime';
import { FragmentRefs } from "relay-runtime";
export type AddFriendSidebarUserSearchRefetchQuery$variables = {
  query: string;
};
export type AddFriendSidebarUserSearchRefetchQuery$data = {
  readonly " $fragmentSpreads": FragmentRefs<"AddFriendSidebarUserSearchFragment">;
};
export type AddFriendSidebarUserSearchRefetchQuery = {
  response: AddFriendSidebarUserSearchRefetchQuery$data;
  variables: AddFriendSidebarUserSearchRefetchQuery$variables;
};

const node: ConcreteRequest = (function(){
var v0 = [
  {
    "defaultValue": null,
    "kind": "LocalArgument",
    "name": "query"
  }
],
v1 = {
  "kind": "Variable",
  "name": "query",
  "variableName": "query"
};
return {
  "fragment": {
    "argumentDefinitions": (v0/*: any*/),
    "kind": "Fragment",
    "metadata": null,
    "name": "AddFriendSidebarUserSearchRefetchQuery",
    "selections": [
      {
        "args": [
          (v1/*: any*/)
        ],
        "kind": "FragmentSpread",
        "name": "AddFriendSidebarUserSearchFragment"
      }
    ],
    "type": "Query",
    "abstractKey": null
  },
  "kind": "Request",
  "operation": {
    "argumentDefinitions": (v0/*: any*/),
    "kind": "Operation",
    "name": "AddFriendSidebarUserSearchRefetchQuery",
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
              (v1/*: any*/),
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
                "alias": null,
                "args": null,
                "kind": "ScalarField",
                "name": "__typename",
                "storageKey": null
              },
              {
                "kind": "InlineFragment",
                "selections": [
                  {
                    "alias": null,
                    "args": null,
                    "kind": "ScalarField",
                    "name": "id",
                    "storageKey": null
                  },
                  {
                    "alias": null,
                    "args": null,
                    "kind": "ScalarField",
                    "name": "email",
                    "storageKey": null
                  },
                  {
                    "alias": null,
                    "args": null,
                    "concreteType": "Friendship",
                    "kind": "LinkedField",
                    "name": "viewerRelation",
                    "plural": false,
                    "selections": [
                      {
                        "alias": null,
                        "args": null,
                        "kind": "ScalarField",
                        "name": "status",
                        "storageKey": null
                      }
                    ],
                    "storageKey": null
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
    ]
  },
  "params": {
    "cacheID": "d0b8b812d9b03ff8ee31e940e37674af",
    "id": null,
    "metadata": {},
    "name": "AddFriendSidebarUserSearchRefetchQuery",
    "operationKind": "query",
    "text": "query AddFriendSidebarUserSearchRefetchQuery(\n  $query: String!\n) {\n  ...AddFriendSidebarUserSearchFragment_1Qr5xf\n}\n\nfragment AddFriendSidebarUserSearchFragment_1Qr5xf on Query {\n  search(input: {first: 50, query: $query, type: USER}) {\n    nodes {\n      __typename\n      ... on User {\n        ...SearchResultsFragment\n        id\n      }\n    }\n  }\n}\n\nfragment SearchResultsFragment on User {\n  id\n  email\n  viewerRelation {\n    status\n  }\n}\n"
  }
};
})();

(node as any).hash = "46b8719377101f75ad2bc988924e8876";

export default node;
