import {
  GraphQLBoolean,
  GraphQLID,
  GraphQLNonNull,
  GraphQLObjectType,
} from "graphql";

const PageInfo: GraphQLObjectType = new GraphQLObjectType({
  name: "PageInfo",
  fields: {
    startCursor: { type: GraphQLID },
    endCursor: { type: GraphQLID },
    hasPreviousPage: { type: new GraphQLNonNull(GraphQLBoolean) },
    hasNextPage: { type: new GraphQLNonNull(GraphQLBoolean) },
  },
});

export { PageInfo };
