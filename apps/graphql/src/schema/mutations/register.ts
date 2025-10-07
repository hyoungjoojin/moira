import {
  GraphQLInputObjectType,
  GraphQLNonNull,
  GraphQLString,
  type GraphQLFieldConfig,
} from "graphql";
import { User } from "../models/index.js";

const RegisterUserInput = new GraphQLInputObjectType({
  name: "RegisterUserInput",
  fields: {
    email: { type: new GraphQLNonNull(GraphQLString) },
    password: { type: new GraphQLNonNull(GraphQLString) },
  },
});

const register: GraphQLFieldConfig<any, any> = {
  type: User,
  args: {
    input: {
      type: RegisterUserInput,
    },
  },
};

export default register;
