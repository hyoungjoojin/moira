/**
 * @generated SignedSource<<d416c99da16a707124f92931c7e6ea69>>
 * @lightSyntaxTransform
 * @nogrep
 */

/* tslint:disable */
/* eslint-disable */
// @ts-nocheck

import { ConcreteRequest } from 'relay-runtime';
export type FriendPageUserQuery$variables = {
  id: string;
};
export type FriendPageUserQuery$data = {
  readonly user: {
    readonly email: string;
  } | null | undefined;
};
export type FriendPageUserQuery = {
  response: FriendPageUserQuery$data;
  variables: FriendPageUserQuery$variables;
};

const node: ConcreteRequest = (function(){
var v0 = [
  {
    "defaultValue": null,
    "kind": "LocalArgument",
    "name": "id"
  }
],
v1 = [
  {
    "kind": "Variable",
    "name": "id",
    "variableName": "id"
  }
],
v2 = {
  "alias": null,
  "args": null,
  "kind": "ScalarField",
  "name": "email",
  "storageKey": null
};
return {
  "fragment": {
    "argumentDefinitions": (v0/*: any*/),
    "kind": "Fragment",
    "metadata": null,
    "name": "FriendPageUserQuery",
    "selections": [
      {
        "alias": null,
        "args": (v1/*: any*/),
        "concreteType": "User",
        "kind": "LinkedField",
        "name": "user",
        "plural": false,
        "selections": [
          (v2/*: any*/)
        ],
        "storageKey": null
      }
    ],
    "type": "Query",
    "abstractKey": null
  },
  "kind": "Request",
  "operation": {
    "argumentDefinitions": (v0/*: any*/),
    "kind": "Operation",
    "name": "FriendPageUserQuery",
    "selections": [
      {
        "alias": null,
        "args": (v1/*: any*/),
        "concreteType": "User",
        "kind": "LinkedField",
        "name": "user",
        "plural": false,
        "selections": [
          (v2/*: any*/),
          {
            "alias": null,
            "args": null,
            "kind": "ScalarField",
            "name": "id",
            "storageKey": null
          }
        ],
        "storageKey": null
      }
    ]
  },
  "params": {
    "cacheID": "d6c2fe6349454182b8136b7614922bce",
    "id": null,
    "metadata": {},
    "name": "FriendPageUserQuery",
    "operationKind": "query",
    "text": "query FriendPageUserQuery(\n  $id: ID!\n) {\n  user(id: $id) {\n    email\n    id\n  }\n}\n"
  }
};
})();

(node as any).hash = "b71d668de4a0e9bc87dea2b17e43e1bd";

export default node;
