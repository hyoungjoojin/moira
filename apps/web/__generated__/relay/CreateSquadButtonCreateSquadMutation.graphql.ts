/**
 * @generated SignedSource<<57b254b291ae03371bb5c42575452540>>
 * @lightSyntaxTransform
 * @nogrep
 */

/* tslint:disable */
/* eslint-disable */
// @ts-nocheck

import { ConcreteRequest } from 'relay-runtime';
export type CreateSquadInput = {
  name: string;
};
export type CreateSquadButtonCreateSquadMutation$variables = {
  input?: CreateSquadInput | null | undefined;
};
export type CreateSquadButtonCreateSquadMutation$data = {
  readonly createSquad: {
    readonly id: string;
  } | null | undefined;
};
export type CreateSquadButtonCreateSquadMutation = {
  response: CreateSquadButtonCreateSquadMutation$data;
  variables: CreateSquadButtonCreateSquadMutation$variables;
};

const node: ConcreteRequest = (function(){
var v0 = [
  {
    "defaultValue": null,
    "kind": "LocalArgument",
    "name": "input"
  }
],
v1 = [
  {
    "alias": null,
    "args": [
      {
        "kind": "Variable",
        "name": "input",
        "variableName": "input"
      }
    ],
    "concreteType": "Squad",
    "kind": "LinkedField",
    "name": "createSquad",
    "plural": false,
    "selections": [
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
];
return {
  "fragment": {
    "argumentDefinitions": (v0/*: any*/),
    "kind": "Fragment",
    "metadata": null,
    "name": "CreateSquadButtonCreateSquadMutation",
    "selections": (v1/*: any*/),
    "type": "Mutation",
    "abstractKey": null
  },
  "kind": "Request",
  "operation": {
    "argumentDefinitions": (v0/*: any*/),
    "kind": "Operation",
    "name": "CreateSquadButtonCreateSquadMutation",
    "selections": (v1/*: any*/)
  },
  "params": {
    "cacheID": "49ad37646a75cb1cf9a02eeb2f0ec412",
    "id": null,
    "metadata": {},
    "name": "CreateSquadButtonCreateSquadMutation",
    "operationKind": "mutation",
    "text": "mutation CreateSquadButtonCreateSquadMutation(\n  $input: CreateSquadInput\n) {\n  createSquad(input: $input) {\n    id\n  }\n}\n"
  }
};
})();

(node as any).hash = "975e7b5356463bb8d8523f16422fef45";

export default node;
