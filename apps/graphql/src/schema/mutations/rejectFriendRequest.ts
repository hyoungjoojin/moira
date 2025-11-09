import {
  GraphQLID,
  GraphQLInputObjectType,
  GraphQLNonNull,
  type GraphQLFieldConfig,
} from "graphql";

const rejectFriendRequest: GraphQLFieldConfig<any, any> = {
  type: GraphQLID,
  args: {
    input: {
      type: new GraphQLInputObjectType({
        name: "RejectFriendRequestInput",
        fields: {
          friendId: { type: new GraphQLNonNull(GraphQLID) },
        },
      }),
    },
  },
};

export default rejectFriendRequest;
