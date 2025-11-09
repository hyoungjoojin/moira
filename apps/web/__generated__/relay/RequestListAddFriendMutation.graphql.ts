/**
 * @generated SignedSource<<6b04c1e200e518138c62cd1946fd89f2>>
 * @lightSyntaxTransform
 * @nogrep
 */

/* tslint:disable */
/* eslint-disable */
// @ts-nocheck

import { ConcreteRequest } from 'relay-runtime';
export type RequestListAddFriendMutation$variables = {
  id: string;
};
export type RequestListAddFriendMutation$data = {
  readonly sendFriendRequest: string | null | undefined;
};
export type RequestListAddFriendMutation = {
  response: RequestListAddFriendMutation$data;
  variables: RequestListAddFriendMutation$variables;
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
    "alias": null,
    "args": [
      {
        "fields": [
          {
            "kind": "Variable",
            "name": "friendId",
            "variableName": "id"
          }
        ],
        "kind": "ObjectValue",
        "name": "input"
      }
    ],
    "kind": "ScalarField",
    "name": "sendFriendRequest",
    "storageKey": null
  }
];
return {
  "fragment": {
    "argumentDefinitions": (v0/*: any*/),
    "kind": "Fragment",
    "metadata": null,
    "name": "RequestListAddFriendMutation",
    "selections": (v1/*: any*/),
    "type": "Mutation",
    "abstractKey": null
  },
  "kind": "Request",
  "operation": {
    "argumentDefinitions": (v0/*: any*/),
    "kind": "Operation",
    "name": "RequestListAddFriendMutation",
    "selections": (v1/*: any*/)
  },
  "params": {
    "cacheID": "4ab8023531a477aab5c6ebb66d393108",
    "id": null,
    "metadata": {},
    "name": "RequestListAddFriendMutation",
    "operationKind": "mutation",
    "text": "mutation RequestListAddFriendMutation(\n  $id: ID!\n) {\n  sendFriendRequest(input: {friendId: $id})\n}\n"
  }
};
})();

(node as any).hash = "8cd1e0c6c91fc3f9e880b7fa8ba5b345";

export default node;
