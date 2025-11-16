/**
 * @generated SignedSource<<86cc3108d29302303ecf4683bc2f7253>>
 * @lightSyntaxTransform
 * @nogrep
 */

/* tslint:disable */
/* eslint-disable */
// @ts-nocheck

import { ConcreteRequest } from 'relay-runtime';
export type SearchResultsRejectFriendRequestMutation$variables = {
  id: string;
};
export type SearchResultsRejectFriendRequestMutation$data = {
  readonly rejectFriendRequest: string | null | undefined;
};
export type SearchResultsRejectFriendRequestMutation = {
  response: SearchResultsRejectFriendRequestMutation$data;
  variables: SearchResultsRejectFriendRequestMutation$variables;
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
    "name": "rejectFriendRequest",
    "storageKey": null
  }
];
return {
  "fragment": {
    "argumentDefinitions": (v0/*: any*/),
    "kind": "Fragment",
    "metadata": null,
    "name": "SearchResultsRejectFriendRequestMutation",
    "selections": (v1/*: any*/),
    "type": "Mutation",
    "abstractKey": null
  },
  "kind": "Request",
  "operation": {
    "argumentDefinitions": (v0/*: any*/),
    "kind": "Operation",
    "name": "SearchResultsRejectFriendRequestMutation",
    "selections": (v1/*: any*/)
  },
  "params": {
    "cacheID": "657d7805cb028cdebac8f99a219496de",
    "id": null,
    "metadata": {},
    "name": "SearchResultsRejectFriendRequestMutation",
    "operationKind": "mutation",
    "text": "mutation SearchResultsRejectFriendRequestMutation(\n  $id: ID!\n) {\n  rejectFriendRequest(input: {friendId: $id})\n}\n"
  }
};
})();

(node as any).hash = "9ff3f8d1b8f4663327ccfccde76ce44d";

export default node;
