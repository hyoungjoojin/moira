import {
  GraphQLInt,
  GraphQLList,
  GraphQLNonNull,
  GraphQLObjectType,
  GraphQLString,
  type GraphQLFieldConfig,
} from "graphql";
import User from "./index.js";
import PageInfo from "../../shared/PageInfo.js";
import { DateTime } from "../../scalars/datetime.js";
import FriendshipStatus from "../../enums/FriendshipStatus.js";

const Friendship = new GraphQLObjectType({
  name: "Friendship",
  fields: () => ({
    leftUser: { type: new GraphQLNonNull(User) },
    rightUser: { type: new GraphQLNonNull(User) },
    status: { type: new GraphQLNonNull(FriendshipStatus) },
    since: { type: DateTime },
  }),
});

const FriendEdge: GraphQLObjectType = new GraphQLObjectType({
  name: "FriendEdge",
  fields: () => ({
    node: { type: new GraphQLNonNull(Friendship) },
    cursor: { type: new GraphQLNonNull(GraphQLString) },
  }),
});

const FriendConnection: GraphQLObjectType = new GraphQLObjectType({
  name: "FriendConnection",
  fields: () => ({
    totalCount: { type: new GraphQLNonNull(GraphQLInt) },
    edges: {
      type: new GraphQLNonNull(new GraphQLList(FriendEdge)),
    },
    nodes: {
      type: new GraphQLNonNull(new GraphQLList(new GraphQLNonNull(Friendship))),
    },
    pageInfo: {
      type: new GraphQLNonNull(PageInfo),
    },
  }),
});

const Friends: GraphQLFieldConfig<any, any> = {
  type: new GraphQLNonNull(FriendConnection),
  args: {
    first: { type: GraphQLInt },
    after: { type: GraphQLString },
  },
};

export default Friends;
export { Friendship };
