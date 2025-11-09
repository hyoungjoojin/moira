import { User } from "./user.js";
import { Squad } from "./squad.js";
import {
  FriendRequestNotification,
  Notification,
  SquadInviteNotification,
} from "./notification.js";
import type { GraphQLNamedType } from "graphql";
import { PageInfo } from "./shared.js";

const types: GraphQLNamedType[] = [
  User,
  Squad,
  Notification,
  SquadInviteNotification,
  FriendRequestNotification,
  PageInfo,
];

export default types;
export { User, Squad, Notification };
