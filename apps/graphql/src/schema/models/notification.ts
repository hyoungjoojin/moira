import {
  GraphQLID,
  GraphQLInterfaceType,
  GraphQLNonNull,
  GraphQLObjectType,
} from "graphql";
import { DateTime } from "../scalars/datetime.js";
import { Invitation } from "./squad.js";
import { User } from "./user.js";

const Notification = new GraphQLInterfaceType({
  name: "Notification",
  fields: () => ({
    id: {
      type: new GraphQLNonNull(GraphQLID),
    },
    createdAt: {
      type: new GraphQLNonNull(DateTime),
    },
  }),
});

const SquadInviteNotification = new GraphQLObjectType({
  name: "SquadInviteNotification",
  interfaces: [Notification],
  fields: () => ({
    id: {
      type: new GraphQLNonNull(GraphQLID),
    },
    createdAt: {
      type: new GraphQLNonNull(DateTime),
    },
    invitation: {
      type: new GraphQLNonNull(Invitation),
    },
  }),
});

const FriendRequestNotification = new GraphQLObjectType({
  name: "FriendRequestNotification",
  interfaces: [Notification],
  fields: () => ({
    id: {
      type: new GraphQLNonNull(GraphQLID),
    },
    createdAt: {
      type: new GraphQLNonNull(DateTime),
    },
    requester: {
      type: new GraphQLNonNull(User),
    },
  }),
});

export { Notification, SquadInviteNotification, FriendRequestNotification };
