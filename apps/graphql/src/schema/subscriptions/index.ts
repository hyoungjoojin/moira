import { GraphQLObjectType } from "graphql";

const subscription = new GraphQLObjectType({
  name: "Subscription",
  fields: {
    notificationCreated: (await import("./notificationCreated.js")).default,
  },
});

export default subscription;
