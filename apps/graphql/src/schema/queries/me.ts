import { GraphQLNonNull, type GraphQLFieldConfig } from "graphql";
import { User } from "../models/user.js";

const me: GraphQLFieldConfig<any, any> = {
  type: new GraphQLNonNull(User),
};

export default me;
