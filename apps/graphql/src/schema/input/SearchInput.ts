import {
  GraphQLInputObjectType,
  GraphQLInt,
  GraphQLNonNull,
  GraphQLString,
} from "graphql";
import SearchType from "../enums/SearchType.js";

const SearchInput = new GraphQLInputObjectType({
  name: "SearchInput",
  fields: {
    first: { type: GraphQLInt },
    after: { type: GraphQLString },
    query: { type: new GraphQLNonNull(GraphQLString) },
    type: { type: new GraphQLNonNull(SearchType) },
  },
});

export default SearchInput;
