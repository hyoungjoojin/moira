import { GraphQLObjectType } from "graphql";

const query = new GraphQLObjectType({
  name: "Query",
  fields: {
    me: (await import("./me.js")).default,
    user: (await import("./user.js")).default,
    users: (await import("./users.js")).default,
    squad: (await import("./squad.js")).default,
    notifications: (await import("./notifications.js")).default,
  },
});

export default query;
