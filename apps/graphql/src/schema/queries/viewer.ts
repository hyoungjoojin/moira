import { GraphQLNonNull, type GraphQLFieldConfig } from "graphql";
import { User } from "../models/index.js";

const viewer: GraphQLFieldConfig<any, any> = {
  type: new GraphQLNonNull(User),
};

export default viewer;
