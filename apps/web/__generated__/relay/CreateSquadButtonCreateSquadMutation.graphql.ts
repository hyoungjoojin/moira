/**
 * @generated SignedSource<<4584de307c87afdb80fe16a41d3c0160>>
 * @lightSyntaxTransform
 * @nogrep
 */

/* tslint:disable */
/* eslint-disable */
// @ts-nocheck

import { ConcreteRequest } from 'relay-runtime';
export type CreateSquadButtonCreateSquadMutation$variables = Record<PropertyKey, never>;
export type CreateSquadButtonCreateSquadMutation$data = {
  readonly createSquad: {
    readonly id: string;
    readonly name: string;
  } | null | undefined;
};
export type CreateSquadButtonCreateSquadMutation = {
  response: CreateSquadButtonCreateSquadMutation$data;
  variables: CreateSquadButtonCreateSquadMutation$variables;
};

const node: ConcreteRequest = (function(){
var v0 = [
  {
    "alias": null,
    "args": [
      {
        "kind": "Literal",
        "name": "input",
        "value": {
          "name": "New Squad"
        }
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
      },
      {
        "alias": null,
        "args": null,
        "kind": "ScalarField",
        "name": "name",
        "storageKey": null
      }
    ],
    "storageKey": "createSquad(input:{\"name\":\"New Squad\"})"
  }
];
return {
  "fragment": {
    "argumentDefinitions": [],
    "kind": "Fragment",
    "metadata": null,
    "name": "CreateSquadButtonCreateSquadMutation",
    "selections": (v0/*: any*/),
    "type": "Mutation",
    "abstractKey": null
  },
  "kind": "Request",
  "operation": {
    "argumentDefinitions": [],
    "kind": "Operation",
    "name": "CreateSquadButtonCreateSquadMutation",
    "selections": (v0/*: any*/)
  },
  "params": {
    "cacheID": "9cb248c70e8d2e85e9d4ce4d458afba9",
    "id": null,
    "metadata": {},
    "name": "CreateSquadButtonCreateSquadMutation",
    "operationKind": "mutation",
    "text": "mutation CreateSquadButtonCreateSquadMutation {\n  createSquad(input: {name: \"New Squad\"}) {\n    id\n    name\n  }\n}\n"
  }
};
})();

(node as any).hash = "fe2351e14941d2b11042a2c8f8d01036";

export default node;
