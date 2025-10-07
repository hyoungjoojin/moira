import { GraphQLID, GraphQLNonNull, type GraphQLFieldConfig } from "graphql";
import { User } from "../models/index.js";

const user: GraphQLFieldConfig<any, any> = {
  type: User,
  args: {
    id: { type: new GraphQLNonNull(GraphQLID) },
  },
};

export default user;
