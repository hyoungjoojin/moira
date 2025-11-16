/**
 * @generated SignedSource<<7343294c1d483422609a7b9b0e3b8aac>>
 * @lightSyntaxTransform
 * @nogrep
 */

/* tslint:disable */
/* eslint-disable */
// @ts-nocheck

import { ConcreteRequest } from 'relay-runtime';
export type SearchResultsAcceptFriendRequestMutation$variables = {
  id: string;
};
export type SearchResultsAcceptFriendRequestMutation$data = {
  readonly acceptFriendRequest: string | null | undefined;
};
export type SearchResultsAcceptFriendRequestMutation = {
  response: SearchResultsAcceptFriendRequestMutation$data;
  variables: SearchResultsAcceptFriendRequestMutation$variables;
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
    "name": "acceptFriendRequest",
    "storageKey": null
  }
];
return {
  "fragment": {
    "argumentDefinitions": (v0/*: any*/),
    "kind": "Fragment",
    "metadata": null,
    "name": "SearchResultsAcceptFriendRequestMutation",
    "selections": (v1/*: any*/),
    "type": "Mutation",
    "abstractKey": null
  },
  "kind": "Request",
  "operation": {
    "argumentDefinitions": (v0/*: any*/),
    "kind": "Operation",
    "name": "SearchResultsAcceptFriendRequestMutation",
    "selections": (v1/*: any*/)
  },
  "params": {
    "cacheID": "f2c52ca6770bb102b2ae8a948f98dd46",
    "id": null,
    "metadata": {},
    "name": "SearchResultsAcceptFriendRequestMutation",
    "operationKind": "mutation",
    "text": "mutation SearchResultsAcceptFriendRequestMutation(\n  $id: ID!\n) {\n  acceptFriendRequest(input: {friendId: $id})\n}\n"
  }
};
})();

(node as any).hash = "db5f5974bd8b56ae33ad28f4b4cf5a0d";

export default node;
