import {
  GraphQLID,
  GraphQLList,
  GraphQLNonNull,
  GraphQLObjectType,
  GraphQLString,
} from "graphql";
import { DateTime } from "../scalars/datetime.js";
import { Squad } from "./squad.js";

const User: GraphQLObjectType = new GraphQLObjectType({
  name: "User",
  fields: () => ({
    id: {
      type: new GraphQLNonNull(GraphQLID),
    },
    email: {
      type: new GraphQLNonNull(GraphQLString),
    },
    squads: {
      type: new GraphQLNonNull(new GraphQLList(Squad)),
    },
    createdAt: {
      type: new GraphQLNonNull(DateTime),
    },
  }),
});

export { User };
