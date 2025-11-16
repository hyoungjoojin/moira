import { GraphQLEnumType } from "graphql";

const SearchType = new GraphQLEnumType({
  name: "SearchType",
  values: {
    USER: { value: "USER" },
  },
});

export default SearchType;
