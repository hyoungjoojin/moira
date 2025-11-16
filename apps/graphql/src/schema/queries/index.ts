import { GraphQLObjectType } from "graphql";

const query = new GraphQLObjectType({
  name: "Query",
  fields: {
    user: (await import("./user.js")).default,
    squad: (await import("./squad.js")).default,
    notifications: (await import("./notifications.js")).default,
    viewer: (await import("./viewer.js")).default,
    search: (await import("./search.js")).default,
  },
});

export default query;
