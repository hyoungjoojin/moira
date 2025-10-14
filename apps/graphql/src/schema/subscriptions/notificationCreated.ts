import { type GraphQLFieldConfig } from "graphql";
import { Notification } from "../models/notification.js";

const NotificationCreated: GraphQLFieldConfig<any, any> = {
  type: Notification,
};

export default NotificationCreated;
