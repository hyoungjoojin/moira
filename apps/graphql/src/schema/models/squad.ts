import {
  GraphQLEnumType,
  GraphQLID,
  GraphQLList,
  GraphQLNonNull,
  GraphQLObjectType,
  GraphQLString,
} from "graphql";
import User from "./user/index.js";
import { DateTime } from "../scalars/datetime.js";

const Member = new GraphQLObjectType({
  name: "Member",
  fields: () => ({
    user: {
      type: new GraphQLNonNull(User),
    },
    joinedAt: {
      type: new GraphQLNonNull(DateTime),
    },
    invitedBy: {
      type: User,
    },
  }),
});

const InvitationStatus = new GraphQLEnumType({
  name: "InvitationStatus",
  values: {
    PENDING: { value: "PENDING" },
    ACCEPTED: { value: "ACCEPTED" },
    REJECTED: { value: "REJECTED" },
  },
});

const Invitation: GraphQLObjectType = new GraphQLObjectType({
  name: "Invitation",
  fields: () => ({
    inviter: {
      type: new GraphQLNonNull(User),
    },
    invitee: {
      type: new GraphQLNonNull(User),
    },
    invitedTo: {
      type: new GraphQLNonNull(Squad),
    },
    sentAt: {
      type: new GraphQLNonNull(DateTime),
    },
    status: {
      type: new GraphQLNonNull(InvitationStatus),
    },
  }),
});

const Squad = new GraphQLObjectType({
  name: "Squad",
  fields: () => ({
    id: {
      type: new GraphQLNonNull(GraphQLID),
    },
    name: {
      type: new GraphQLNonNull(GraphQLString),
    },
    members: {
      type: new GraphQLNonNull(new GraphQLList(Member)),
    },
    invitations: {
      type: new GraphQLNonNull(new GraphQLList(Invitation)),
    },
    createdAt: {
      type: new GraphQLNonNull(DateTime),
    },
  }),
});

export { Squad, Invitation };
