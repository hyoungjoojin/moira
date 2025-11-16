import { GraphQLEnumType } from "graphql";

const FriendshipStatus = new GraphQLEnumType({
  name: "FriendshipStatus",
  values: {
    FRIENDS: { value: "FRIENDS" },
    NOT_FRIENDS: { value: "NOT_FRIENDS" },
    REQUEST_PENDING: { value: "REQUEST_PENDING" },
    REQUEST_REJECTED: { value: "REQUEST_REJECTED" },
  },
});

export default FriendshipStatus;
