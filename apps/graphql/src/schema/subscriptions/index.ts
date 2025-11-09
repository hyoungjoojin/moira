import { GraphQLObjectType } from "graphql";

const subscription = new GraphQLObjectType({
  name: "Subscription",
  fields: {
    newNotification: (await import("./newNotification.js")).default,
  },
});

export default subscription;
