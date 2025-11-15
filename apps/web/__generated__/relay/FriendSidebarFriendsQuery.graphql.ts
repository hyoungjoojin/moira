/**
 * @generated SignedSource<<cb25884bae6193916ac84106a3eb5ef1>>
 * @lightSyntaxTransform
 * @nogrep
 */

/* tslint:disable */
/* eslint-disable */
// @ts-nocheck

import { ConcreteRequest } from 'relay-runtime';
export type FriendSidebarFriendsQuery$variables = {
  after?: string | null | undefined;
  first?: number | null | undefined;
};
export type FriendSidebarFriendsQuery$data = {
  readonly me: {
    readonly friends: {
      readonly nodes: ReadonlyArray<{
        readonly email: string;
        readonly id: string;
      }>;
    };
  };
};
export type FriendSidebarFriendsQuery = {
  response: FriendSidebarFriendsQuery$data;
  variables: FriendSidebarFriendsQuery$variables;
};

const node: ConcreteRequest = (function(){
var v0 = {
  "defaultValue": null,
  "kind": "LocalArgument",
  "name": "after"
},
v1 = {
  "defaultValue": 20,
  "kind": "LocalArgument",
  "name": "first"
},
v2 = {
  "alias": null,
  "args": null,
  "kind": "ScalarField",
  "name": "id",
  "storageKey": null
},
v3 = {
  "alias": null,
  "args": [
    {
      "kind": "Variable",
      "name": "after",
      "variableName": "after"
    },
    {
      "kind": "Variable",
      "name": "first",
      "variableName": "first"
    }
  ],
  "concreteType": "FriendConnection",
  "kind": "LinkedField",
  "name": "friends",
  "plural": false,
  "selections": [
    {
      "alias": null,
      "args": null,
      "concreteType": "User",
      "kind": "LinkedField",
      "name": "nodes",
      "plural": true,
      "selections": [
        (v2/*: any*/),
        {
          "alias": null,
          "args": null,
          "kind": "ScalarField",
          "name": "email",
          "storageKey": null
        }
      ],
      "storageKey": null
    }
  ],
  "storageKey": null
};
return {
  "fragment": {
    "argumentDefinitions": [
      (v0/*: any*/),
      (v1/*: any*/)
    ],
    "kind": "Fragment",
    "metadata": null,
    "name": "FriendSidebarFriendsQuery",
    "selections": [
      {
        "alias": null,
        "args": null,
        "concreteType": "User",
        "kind": "LinkedField",
        "name": "me",
        "plural": false,
        "selections": [
          (v3/*: any*/)
        ],
        "storageKey": null
      }
    ],
    "type": "Query",
    "abstractKey": null
  },
  "kind": "Request",
  "operation": {
    "argumentDefinitions": [
      (v1/*: any*/),
      (v0/*: any*/)
    ],
    "kind": "Operation",
    "name": "FriendSidebarFriendsQuery",
    "selections": [
      {
        "alias": null,
        "args": null,
        "concreteType": "User",
        "kind": "LinkedField",
        "name": "me",
        "plural": false,
        "selections": [
          (v3/*: any*/),
          (v2/*: any*/)
        ],
        "storageKey": null
      }
    ]
  },
  "params": {
    "cacheID": "798dc4246bda95e100d104a4cca01cc3",
    "id": null,
    "metadata": {},
    "name": "FriendSidebarFriendsQuery",
    "operationKind": "query",
    "text": "query FriendSidebarFriendsQuery(\n  $first: Int = 20\n  $after: String\n) {\n  me {\n    friends(first: $first, after: $after) {\n      nodes {\n        id\n        email\n      }\n    }\n    id\n  }\n}\n"
  }
};
})();

(node as any).hash = "a33ec55d84fb1f4087cf2bff3951b3cb";

export default node;
