import { GraphQLObjectType } from "graphql";

const mutation = new GraphQLObjectType({
  name: "Mutation",
  fields: {
    register: (await import("./register.js")).default,
    createSquad: (await import("./createSquad.js")).default,
  },
});

export default mutation;
