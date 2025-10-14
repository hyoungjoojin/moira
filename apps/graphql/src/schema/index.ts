import query from "./queries/index.js";
import mutation from "./mutations/index.js";
import subscription from "./subscriptions/index.js";
import { GraphQLSchema } from "graphql";
import types from "./models/index.js";

const schema = new GraphQLSchema({
  types,
  query,
  mutation,
  subscription,
});

export default schema;
