import {
  GraphQLID,
  GraphQLInputObjectType,
  GraphQLNonNull,
  type GraphQLFieldConfig,
} from "graphql";

const SendFriendRequestInput = new GraphQLInputObjectType({
  name: "SendFriendRequestInput",
  fields: {
    friendId: { type: new GraphQLNonNull(GraphQLID) },
  },
});

const sendFriendRequest: GraphQLFieldConfig<any, any> = {
  type: GraphQLID,
  args: {
    input: {
      type: SendFriendRequestInput,
    },
  },
};

export default sendFriendRequest;
