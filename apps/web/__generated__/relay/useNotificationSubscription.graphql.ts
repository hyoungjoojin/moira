/**
 * @generated SignedSource<<8173e7589ef36ad3b453b1ace20d5f96>>
 * @lightSyntaxTransform
 * @nogrep
 */

/* tslint:disable */
/* eslint-disable */
// @ts-nocheck

import { ConcreteRequest } from 'relay-runtime';
export type useNotificationSubscription$variables = Record<PropertyKey, never>;
export type useNotificationSubscription$data = {
  readonly newNotification: {
    readonly id: string;
  } | null | undefined;
};
export type useNotificationSubscription = {
  response: useNotificationSubscription$data;
  variables: useNotificationSubscription$variables;
};

const node: ConcreteRequest = (function(){
var v0 = {
  "alias": null,
  "args": null,
  "kind": "ScalarField",
  "name": "id",
  "storageKey": null
};
return {
  "fragment": {
    "argumentDefinitions": [],
    "kind": "Fragment",
    "metadata": null,
    "name": "useNotificationSubscription",
    "selections": [
      {
        "alias": null,
        "args": null,
        "concreteType": null,
        "kind": "LinkedField",
        "name": "newNotification",
        "plural": false,
        "selections": [
          (v0/*: any*/)
        ],
        "storageKey": null
      }
    ],
    "type": "Subscription",
    "abstractKey": null
  },
  "kind": "Request",
  "operation": {
    "argumentDefinitions": [],
    "kind": "Operation",
    "name": "useNotificationSubscription",
    "selections": [
      {
        "alias": null,
        "args": null,
        "concreteType": null,
        "kind": "LinkedField",
        "name": "newNotification",
        "plural": false,
        "selections": [
          {
            "alias": null,
            "args": null,
            "kind": "ScalarField",
            "name": "__typename",
            "storageKey": null
          },
          (v0/*: any*/)
        ],
        "storageKey": null
      }
    ]
  },
  "params": {
    "cacheID": "b23fbfd62bafd6e2a0a00c3349ca5648",
    "id": null,
    "metadata": {},
    "name": "useNotificationSubscription",
    "operationKind": "subscription",
    "text": "subscription useNotificationSubscription {\n  newNotification {\n    __typename\n    id\n  }\n}\n"
  }
};
})();

(node as any).hash = "521df62b88fe1bfbae5de3815ba42a18";

export default node;
