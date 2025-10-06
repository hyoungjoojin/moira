import {
  GraphQLID,
  GraphQLInputObjectType,
  GraphQLNonNull,
  GraphQLObjectType,
  GraphQLString,
} from "graphql";
import type { QueryFields } from "./index.js";

const User = new GraphQLObjectType({
  name: "User",
  fields: {
    id: {
      type: new GraphQLNonNull(GraphQLID),
    },
    email: {
      type: new GraphQLNonNull(GraphQLString),
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

const RegistrationInput = new GraphQLInputObjectType({
  name: "RegistrationInput",
  fields: {
    email: { type: new GraphQLNonNull(GraphQLString) },
  },
});

const UserMutation: QueryFields = {
  register: {
    type: User,
    args: {
      input: {
        type: RegistrationInput,
      },
    },
  },
};

export { User, UserQuery, UserMutation };
