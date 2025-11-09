/**
 * @generated SignedSource<<db5aaddf2983b6115f1fcc9333d452ef>>
 * @lightSyntaxTransform
 * @nogrep
 */

/* tslint:disable */
/* eslint-disable */
// @ts-nocheck

import { ConcreteRequest } from 'relay-runtime';
export type LoginInput = {
  email: string;
  password: string;
};
export type LoginFormLoginUserMutation$variables = {
  input?: LoginInput | null | undefined;
};
export type LoginFormLoginUserMutation$data = {
  readonly login: {
    readonly id: string;
  } | null | undefined;
};
export type LoginFormLoginUserMutation = {
  response: LoginFormLoginUserMutation$data;
  variables: LoginFormLoginUserMutation$variables;
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
    "concreteType": "User",
    "kind": "LinkedField",
    "name": "login",
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
    "name": "LoginFormLoginUserMutation",
    "selections": (v1/*: any*/),
    "type": "Mutation",
    "abstractKey": null
  },
  "kind": "Request",
  "operation": {
    "argumentDefinitions": (v0/*: any*/),
    "kind": "Operation",
    "name": "LoginFormLoginUserMutation",
    "selections": (v1/*: any*/)
  },
  "params": {
    "cacheID": "9039408a406dd82c4905ff252997c624",
    "id": null,
    "metadata": {},
    "name": "LoginFormLoginUserMutation",
    "operationKind": "mutation",
    "text": "mutation LoginFormLoginUserMutation(\n  $input: LoginInput\n) {\n  login(input: $input) {\n    id\n  }\n}\n"
  }
};
})();

(node as any).hash = "d7d528479e34cc02a4dcb1609cd34fb9";

export default node;
