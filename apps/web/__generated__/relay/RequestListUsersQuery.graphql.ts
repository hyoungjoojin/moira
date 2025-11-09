/**
 * @generated SignedSource<<13af9564139040c1cc612f07fa9c791e>>
 * @lightSyntaxTransform
 * @nogrep
 */

/* tslint:disable */
/* eslint-disable */
// @ts-nocheck

import { ConcreteRequest } from 'relay-runtime';
export type RequestListUsersQuery$variables = Record<PropertyKey, never>;
export type RequestListUsersQuery$data = {
  readonly users: ReadonlyArray<{
    readonly email: string;
    readonly id: string;
  } | null | undefined>;
};
export type RequestListUsersQuery = {
  response: RequestListUsersQuery$data;
  variables: RequestListUsersQuery$variables;
};

const node: ConcreteRequest = (function(){
var v0 = [
  {
    "alias": null,
    "args": null,
    "concreteType": "User",
    "kind": "LinkedField",
    "name": "users",
    "plural": true,
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
      }
    ],
    "storageKey": null
  }
];
return {
  "fragment": {
    "argumentDefinitions": [],
    "kind": "Fragment",
    "metadata": null,
    "name": "RequestListUsersQuery",
    "selections": (v0/*: any*/),
    "type": "Query",
    "abstractKey": null
  },
  "kind": "Request",
  "operation": {
    "argumentDefinitions": [],
    "kind": "Operation",
    "name": "RequestListUsersQuery",
    "selections": (v0/*: any*/)
  },
  "params": {
    "cacheID": "a77ed545c67a242964c783566a8391ce",
    "id": null,
    "metadata": {},
    "name": "RequestListUsersQuery",
    "operationKind": "query",
    "text": "query RequestListUsersQuery {\n  users {\n    id\n    email\n  }\n}\n"
  }
};
})();

(node as any).hash = "de975bce634d4f54bb628fbf4e6b1c81";

export default node;
