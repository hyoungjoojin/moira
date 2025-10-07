import {
  GraphQLInputObjectType,
  GraphQLNonNull,
  GraphQLString,
  type GraphQLFieldConfig,
} from "graphql";
import { Squad } from "../models/index.js";

const CreateSquadInput = new GraphQLInputObjectType({
  name: "CreateSquadInput",
  fields: {
    name: { type: new GraphQLNonNull(GraphQLString) },
  },
});

const createSquad: GraphQLFieldConfig<any, any> = {
  type: Squad,
  args: {
    input: {
      type: CreateSquadInput,
    },
  },
};

export default createSquad;
