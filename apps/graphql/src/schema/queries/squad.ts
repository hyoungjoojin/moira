import { GraphQLID, GraphQLNonNull, type GraphQLFieldConfig } from "graphql";
import { Squad } from "../models/index.js";

const squad: GraphQLFieldConfig<any, any> = {
  type: Squad,
  args: {
    id: { type: new GraphQLNonNull(GraphQLID) },
  },
};

export default squad;
