import {
  GraphQLID,
  GraphQLInputObjectType,
  GraphQLNonNull,
  type GraphQLFieldConfig,
} from "graphql";

const acceptFriendRequest: GraphQLFieldConfig<any, any> = {
  type: GraphQLID,
  args: {
    input: {
      type: new GraphQLInputObjectType({
        name: "AcceptFriendRequestInput",
        fields: {
          friendId: { type: new GraphQLNonNull(GraphQLID) },
        },
      }),
    },
  },
};

export default acceptFriendRequest;
