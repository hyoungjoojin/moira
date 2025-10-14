import { User } from "./user.js";
import { Squad } from "./squad.js";
import { Notification, SquadInviteNotification } from "./notification.js";
import type { GraphQLNamedType } from "graphql";

const types: GraphQLNamedType[] = [
  User,
  Squad,
  Notification,
  SquadInviteNotification,
];

export default types;
export { User, Squad, Notification };
