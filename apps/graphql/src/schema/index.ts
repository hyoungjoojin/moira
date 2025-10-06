import type { GraphQLFieldConfig, ThunkObjMap } from "graphql";

export type QueryFields = ThunkObjMap<GraphQLFieldConfig<any, any>>;

export * from "./user.js";
