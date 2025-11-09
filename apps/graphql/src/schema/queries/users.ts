import { GraphQLList, GraphQLNonNull, type GraphQLFieldConfig } from "graphql";
import { User } from "../models/index.js";

const users: GraphQLFieldConfig<any, any> = {
  type: new GraphQLNonNull(new GraphQLList(User)),
};

export default users;
