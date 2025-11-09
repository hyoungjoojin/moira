import {
  GraphQLID,
  GraphQLInt,
  GraphQLList,
  GraphQLNonNull,
  GraphQLObjectType,
  GraphQLString,
} from "graphql";
import { DateTime } from "../scalars/datetime.js";
import { Squad } from "./squad.js";
import { PageInfo } from "./shared.js";

const User: GraphQLObjectType = new GraphQLObjectType({
  name: "User",
  fields: () => ({
    id: {
      type: new GraphQLNonNull(GraphQLID),
    },
    email: {
      type: new GraphQLNonNull(GraphQLString),
    },
    fullName: {
      type: GraphQLString,
    },
    bio: {
      type: GraphQLString,
    },
    friends: {
      type: new GraphQLNonNull(FriendConnection),
      args: {
        first: { type: GraphQLInt },
        after: { type: GraphQLString },
      },
    },
    squads: {
      type: new GraphQLNonNull(new GraphQLList(Squad)),
    },
    createdAt: {
      type: new GraphQLNonNull(DateTime),
    },
  }),
});

const FriendEdge: GraphQLObjectType = new GraphQLObjectType({
  name: "FriendEdge",
  fields: {
    node: { type: new GraphQLNonNull(User) },
    friendsSince: { type: new GraphQLNonNull(DateTime) },
    cursor: { type: new GraphQLNonNull(GraphQLString) },
  },
});

const FriendConnection: GraphQLObjectType = new GraphQLObjectType({
  name: "FriendConnection",
  fields: {
    totalCount: { type: new GraphQLNonNull(GraphQLInt) },
    edges: {
      type: new GraphQLNonNull(new GraphQLList(FriendEdge)),
    },
    nodes: {
      type: new GraphQLNonNull(new GraphQLList(new GraphQLNonNull(User))),
    },
    pageInfo: {
      type: new GraphQLNonNull(PageInfo),
    },
  },
});

export { User };
