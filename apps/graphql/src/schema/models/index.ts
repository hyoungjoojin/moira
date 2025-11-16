import { Squad } from "./squad.js";
import User from "./user/index.js";
import {
  FriendRequestNotification,
  Notification,
  SquadInviteNotification,
} from "./notification.js";
import type { GraphQLNamedType } from "graphql";

const types: GraphQLNamedType[] = [
  SquadInviteNotification,
  FriendRequestNotification,
];

export default types;
export { User, Squad, Notification };
