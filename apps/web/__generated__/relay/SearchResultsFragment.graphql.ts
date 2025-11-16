/**
 * @generated SignedSource<<0863b2a653753ddb16329ecc99f13549>>
 * @lightSyntaxTransform
 * @nogrep
 */

/* tslint:disable */
/* eslint-disable */
// @ts-nocheck

import { ReaderFragment } from 'relay-runtime';
export type FriendshipStatus = "FRIENDS" | "NOT_FRIENDS" | "REQUEST_PENDING" | "REQUEST_REJECTED" | "%future added value";
import { FragmentRefs } from "relay-runtime";
export type SearchResultsFragment$data = {
  readonly email: string;
  readonly id: string;
  readonly viewerRelation: {
    readonly status: FriendshipStatus;
  };
  readonly " $fragmentType": "SearchResultsFragment";
};
export type SearchResultsFragment$key = {
  readonly " $data"?: SearchResultsFragment$data;
  readonly " $fragmentSpreads": FragmentRefs<"SearchResultsFragment">;
};

const node: ReaderFragment = {
  "argumentDefinitions": [],
  "kind": "Fragment",
  "metadata": null,
  "name": "SearchResultsFragment",
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
      "name": "email",
      "storageKey": null
    },
    {
      "alias": null,
      "args": null,
      "concreteType": "Friendship",
      "kind": "LinkedField",
      "name": "viewerRelation",
      "plural": false,
      "selections": [
        {
          "alias": null,
          "args": null,
          "kind": "ScalarField",
          "name": "status",
          "storageKey": null
        }
      ],
      "storageKey": null
    }
  ],
  "type": "User",
  "abstractKey": null
};

(node as any).hash = "a6cc03840e7a71d367f0ae33e7725310";

export default node;
