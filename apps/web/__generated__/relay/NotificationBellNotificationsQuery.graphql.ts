/**
 * @generated SignedSource<<6f5317178c64b95c377a2ac43c7366b5>>
 * @lightSyntaxTransform
 * @nogrep
 */

/* tslint:disable */
/* eslint-disable */
// @ts-nocheck

import { ConcreteRequest } from 'relay-runtime';
export type NotificationBellNotificationsQuery$variables = Record<PropertyKey, never>;
export type NotificationBellNotificationsQuery$data = {
  readonly notifications: ReadonlyArray<{
    readonly id: string;
  } | null | undefined> | null | undefined;
};
export type NotificationBellNotificationsQuery = {
  response: NotificationBellNotificationsQuery$data;
  variables: NotificationBellNotificationsQuery$variables;
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
    "name": "NotificationBellNotificationsQuery",
    "selections": [
      {
        "alias": null,
        "args": null,
        "concreteType": null,
        "kind": "LinkedField",
        "name": "notifications",
        "plural": true,
        "selections": [
          (v0/*: any*/)
        ],
        "storageKey": null
      }
    ],
    "type": "Query",
    "abstractKey": null
  },
  "kind": "Request",
  "operation": {
    "argumentDefinitions": [],
    "kind": "Operation",
    "name": "NotificationBellNotificationsQuery",
    "selections": [
      {
        "alias": null,
        "args": null,
        "concreteType": null,
        "kind": "LinkedField",
        "name": "notifications",
        "plural": true,
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
    "cacheID": "2e18913a2c3fc5f334186b5e76441545",
    "id": null,
    "metadata": {},
    "name": "NotificationBellNotificationsQuery",
    "operationKind": "query",
    "text": "query NotificationBellNotificationsQuery {\n  notifications {\n    __typename\n    id\n  }\n}\n"
  }
};
})();

(node as any).hash = "334070341bb7310d40e64b41a583e435";

export default node;
