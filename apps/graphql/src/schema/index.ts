import query from "./queries/index.js";
import mutation from "./mutations/index.js";
import { GraphQLSchema } from "graphql";

const schema = new GraphQLSchema({
  query,
  mutation,
});

export default schema;
