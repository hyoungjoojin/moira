import { GraphQLObjectType } from "graphql";

const mutation = new GraphQLObjectType({
  name: "Mutation",
  fields: {
    login: (await import("./login.js")).default,
    register: (await import("./register.js")).default,
    createSquad: (await import("./createSquad.js")).default,
    inviteUserToSquad: (await import("./inviteUserToSquad.js")).default,
    sendFriendRequest: (await import("./sendFriendRequest.js")).default,
    acceptFriendRequest: (await import("./acceptFriendRequest.js")).default,
    rejectFriendRequest: (await import("./rejectFriendRequest.js")).default,
  },
});

export default mutation;
