import {
  GraphQLID,
  GraphQLInputObjectType,
  GraphQLNonNull,
  type GraphQLFieldConfig,
} from "graphql";

const InviteUserToSquadInput = new GraphQLInputObjectType({
  name: "InviteUserToSquadInput",
  fields: {
    userId: { type: new GraphQLNonNull(GraphQLID) },
    squadId: { type: new GraphQLNonNull(GraphQLID) },
  },
});

const inviteUserToSquad: GraphQLFieldConfig<any, any> = {
  type: GraphQLID,
  args: {
    input: {
      type: InviteUserToSquadInput,
    },
  },
};

export default inviteUserToSquad;
