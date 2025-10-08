import {
  GraphQLInputObjectType,
  GraphQLNonNull,
  GraphQLString,
  type GraphQLFieldConfig,
} from "graphql";
import { User } from "../models/index.js";

const LoginInput = new GraphQLInputObjectType({
  name: "LoginInput",
  fields: {
    email: { type: new GraphQLNonNull(GraphQLString) },
    password: { type: new GraphQLNonNull(GraphQLString) },
  },
});

const login: GraphQLFieldConfig<any, any> = {
  type: User,
  args: {
    input: {
      type: LoginInput,
    },
  },
};

export default login;
