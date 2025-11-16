import {
  GraphQLID,
  GraphQLList,
  GraphQLNonNull,
  GraphQLObjectType,
  GraphQLString,
} from "graphql";
import Friends, { Friendship } from "./friends.js";
import { DateTime } from "../../scalars/datetime.js";
import { Squad } from "../squad.js";

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
    friends: Friends,
    viewerRelation: {
      type: new GraphQLNonNull(Friendship),
    },
    squads: {
      type: new GraphQLNonNull(new GraphQLList(Squad)),
    },
    joinedAt: {
      type: new GraphQLNonNull(DateTime),
    },
  }),
});

export default User;
