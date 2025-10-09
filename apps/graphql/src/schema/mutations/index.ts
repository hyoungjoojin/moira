import { GraphQLObjectType } from "graphql";

const mutation = new GraphQLObjectType({
  name: "Mutation",
  fields: {
    login: (await import("./login.js")).default,
    register: (await import("./register.js")).default,
    createSquad: (await import("./createSquad.js")).default,
    inviteUserToSquad: (await import("./inviteUserToSquad.js")).default,
  },
});

export default mutation;
