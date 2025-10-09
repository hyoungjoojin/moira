import {
  GraphQLID,
  GraphQLList,
  GraphQLNonNull,
  GraphQLObjectType,
  GraphQLString,
} from "graphql";
import { User } from "./user.js";
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
    createdAt: {
      type: new GraphQLNonNull(DateTime),
    },
  }),
});

export { Squad };
