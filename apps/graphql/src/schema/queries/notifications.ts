import { GraphQLList, type GraphQLFieldConfig } from "graphql";
import { Notification } from "../models/notification.js";

const notifications: GraphQLFieldConfig<any, any> = {
  type: new GraphQLList(Notification),
};

export default notifications;
