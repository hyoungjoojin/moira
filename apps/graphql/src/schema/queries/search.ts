import {
  GraphQLID,
  GraphQLInt,
  GraphQLList,
  GraphQLNonNull,
  GraphQLObjectType,
  GraphQLUnionType,
  type GraphQLFieldConfig,
} from "graphql";
import { User } from "../models/index.js";
import SearchInput from "../input/SearchInput.js";
import PageInfo from "../shared/PageInfo.js";

const SearchResultItem: GraphQLUnionType = new GraphQLUnionType({
  name: "SearchResultItem",
  types: [User],
});

const SearchResultEdge = new GraphQLObjectType({
  name: "SearchResultEdge",
  fields: {
    node: {
      type: new GraphQLNonNull(SearchResultItem),
    },
    cursor: { type: new GraphQLNonNull(GraphQLID) },
  },
});

const SearchResultConnection = new GraphQLObjectType({
  name: "SearchResultConnection",
  fields: {
    userCount: { type: new GraphQLNonNull(GraphQLInt) },
    edges: {
      type: new GraphQLNonNull(
        new GraphQLList(new GraphQLNonNull(SearchResultEdge)),
      ),
    },
    nodes: {
      type: new GraphQLNonNull(
        new GraphQLList(new GraphQLNonNull(SearchResultItem)),
      ),
    },
    pageInfo: {
      type: new GraphQLNonNull(PageInfo),
    },
  },
});

const search: GraphQLFieldConfig<any, any> = {
  type: new GraphQLNonNull(SearchResultConnection),
  args: {
    input: { type: new GraphQLNonNull(SearchInput) },
  },
};

export default search;
