import { GraphQLObjectType } from "graphql";

const query = new GraphQLObjectType({
  name: "Query",
  fields: {
    user: (await import("./user.js")).default,
    squad: (await import("./squad.js")).default,
  },
});

export default query;
