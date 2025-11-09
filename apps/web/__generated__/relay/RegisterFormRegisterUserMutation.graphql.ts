/**
 * @generated SignedSource<<49ae14e883f8c2760185549fe55cf433>>
 * @lightSyntaxTransform
 * @nogrep
 */

/* tslint:disable */
/* eslint-disable */
// @ts-nocheck

import { ConcreteRequest } from 'relay-runtime';
export type RegisterUserInput = {
  email: string;
  password: string;
};
export type RegisterFormRegisterUserMutation$variables = {
  input?: RegisterUserInput | null | undefined;
};
export type RegisterFormRegisterUserMutation$data = {
  readonly register: {
    readonly id: string;
  } | null | undefined;
};
export type RegisterFormRegisterUserMutation = {
  response: RegisterFormRegisterUserMutation$data;
  variables: RegisterFormRegisterUserMutation$variables;
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
    "name": "register",
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
    "name": "RegisterFormRegisterUserMutation",
    "selections": (v1/*: any*/),
    "type": "Mutation",
    "abstractKey": null
  },
  "kind": "Request",
  "operation": {
    "argumentDefinitions": (v0/*: any*/),
    "kind": "Operation",
    "name": "RegisterFormRegisterUserMutation",
    "selections": (v1/*: any*/)
  },
  "params": {
    "cacheID": "17cb4329f9710260a041f7ea187e3070",
    "id": null,
    "metadata": {},
    "name": "RegisterFormRegisterUserMutation",
    "operationKind": "mutation",
    "text": "mutation RegisterFormRegisterUserMutation(\n  $input: RegisterUserInput\n) {\n  register(input: $input) {\n    id\n  }\n}\n"
  }
};
})();

(node as any).hash = "1cde6b6465a4ad598d9880605afcef38";

export default node;
