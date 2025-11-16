/**
 * @generated SignedSource<<6845637c30d966a705d37c6748eaed0a>>
 * @lightSyntaxTransform
 * @nogrep
 */

/* tslint:disable */
/* eslint-disable */
// @ts-nocheck

import { ConcreteRequest } from 'relay-runtime';
export type SearchResultsSendFriendRequestMutation$variables = {
  id: string;
};
export type SearchResultsSendFriendRequestMutation$data = {
  readonly sendFriendRequest: string | null | undefined;
};
export type SearchResultsSendFriendRequestMutation = {
  response: SearchResultsSendFriendRequestMutation$data;
  variables: SearchResultsSendFriendRequestMutation$variables;
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
    "name": "SearchResultsSendFriendRequestMutation",
    "selections": (v1/*: any*/),
    "type": "Mutation",
    "abstractKey": null
  },
  "kind": "Request",
  "operation": {
    "argumentDefinitions": (v0/*: any*/),
    "kind": "Operation",
    "name": "SearchResultsSendFriendRequestMutation",
    "selections": (v1/*: any*/)
  },
  "params": {
    "cacheID": "09c9a07016b9f9b5c707437edb3ba045",
    "id": null,
    "metadata": {},
    "name": "SearchResultsSendFriendRequestMutation",
    "operationKind": "mutation",
    "text": "mutation SearchResultsSendFriendRequestMutation(\n  $id: ID!\n) {\n  sendFriendRequest(input: {friendId: $id})\n}\n"
  }
};
})();

(node as any).hash = "50e499462c7430bdfd525c0150ff1693";

export default node;
