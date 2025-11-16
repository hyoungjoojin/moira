/**
 * @generated SignedSource<<32b4fb28142fde0792932f8c80b8a751>>
 * @lightSyntaxTransform
 * @nogrep
 */

/* tslint:disable */
/* eslint-disable */
// @ts-nocheck

import { ConcreteRequest } from 'relay-runtime';
export type FriendListQuery$variables = Record<PropertyKey, never>;
export type FriendListQuery$data = {
  readonly viewer: {
    readonly friends: {
      readonly nodes: ReadonlyArray<{
        readonly rightUser: {
          readonly email: string;
          readonly id: string;
        };
      }>;
    };
  };
};
export type FriendListQuery = {
  response: FriendListQuery$data;
  variables: FriendListQuery$variables;
};

const node: ConcreteRequest = (function(){
var v0 = {
  "alias": null,
  "args": null,
  "kind": "ScalarField",
  "name": "id",
  "storageKey": null
},
v1 = {
  "alias": null,
  "args": null,
  "concreteType": "FriendConnection",
  "kind": "LinkedField",
  "name": "friends",
  "plural": false,
  "selections": [
    {
      "alias": null,
      "args": null,
      "concreteType": "Friendship",
      "kind": "LinkedField",
      "name": "nodes",
      "plural": true,
      "selections": [
        {
          "alias": null,
          "args": null,
          "concreteType": "User",
          "kind": "LinkedField",
          "name": "rightUser",
          "plural": false,
          "selections": [
            (v0/*: any*/),
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
    }
  ],
  "storageKey": null
};
return {
  "fragment": {
    "argumentDefinitions": [],
    "kind": "Fragment",
    "metadata": null,
    "name": "FriendListQuery",
    "selections": [
      {
        "alias": null,
        "args": null,
        "concreteType": "User",
        "kind": "LinkedField",
        "name": "viewer",
        "plural": false,
        "selections": [
          (v1/*: any*/)
        ],
        "storageKey": null
      }
    ],
    "type": "Query",
    "abstractKey": null
  },
  "kind": "Request",
  "operation": {
    "argumentDefinitions": [],
    "kind": "Operation",
    "name": "FriendListQuery",
    "selections": [
      {
        "alias": null,
        "args": null,
        "concreteType": "User",
        "kind": "LinkedField",
        "name": "viewer",
        "plural": false,
        "selections": [
          (v1/*: any*/),
          (v0/*: any*/)
        ],
        "storageKey": null
      }
    ]
  },
  "params": {
    "cacheID": "66d566d7057f3177f9dc946d487cb671",
    "id": null,
    "metadata": {},
    "name": "FriendListQuery",
    "operationKind": "query",
    "text": "query FriendListQuery {\n  viewer {\n    friends {\n      nodes {\n        rightUser {\n          id\n          email\n        }\n      }\n    }\n    id\n  }\n}\n"
  }
};
})();

(node as any).hash = "33c3ac79b839d6e66ff71400ad9192cd";

export default node;
