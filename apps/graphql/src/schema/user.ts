import {
  GraphQLID,
  GraphQLInputObjectType,
  GraphQLNonNull,
  GraphQLObjectType,
  GraphQLString,
} from "graphql";
import type { QueryFields } from "./index.js";
import { DateTime } from "./common.js";

const User = new GraphQLObjectType({
  name: "User",
  fields: {
    id: {
      type: new GraphQLNonNull(GraphQLID),
    },
    email: {
      type: new GraphQLNonNull(GraphQLString),
    },
    createdAt: {
      type: new GraphQLNonNull(DateTime),
    },
  },
});

const UserQuery: QueryFields = {
  user: {
    type: User,
    args: {
      id: { type: new GraphQLNonNull(GraphQLString) },
    },
  },
};

const RegisterUserInput = new GraphQLInputObjectType({
  name: "RegisterUserInput",
  fields: {
    email: { type: new GraphQLNonNull(GraphQLString) },
  },
});

const UserMutation: QueryFields = {
  register: {
    type: User,
    args: {
      input: {
        type: RegisterUserInput,
      },
    },
  },
};

export { User, UserQuery, UserMutation };
