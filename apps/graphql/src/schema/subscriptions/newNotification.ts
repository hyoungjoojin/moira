import { type GraphQLFieldConfig } from "graphql";
import { Notification } from "../models/notification.js";

const NewNotification: GraphQLFieldConfig<any, any> = {
  type: Notification,
};

export default NewNotification;
