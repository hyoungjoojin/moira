import { GraphQLScalarType } from "graphql";

const DateTime = new GraphQLScalarType({
  name: "DateTime",
});

export { DateTime };
