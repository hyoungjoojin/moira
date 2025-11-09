import type { useNotificationSubscription as UseNotificationSubscription } from '@generated/relay/useNotificationSubscription.graphql';
import { useMemo } from 'react';
import { graphql, useSubscription } from 'react-relay';
import type { GraphQLSubscriptionConfig } from 'relay-runtime';

function useNotificationSubscription(
  options?: Partial<GraphQLSubscriptionConfig<UseNotificationSubscription>>,
) {
  const config: GraphQLSubscriptionConfig<UseNotificationSubscription> =
    useMemo(
      () => ({
        subscription: graphql`
          subscription useNotificationSubscription {
            newNotification {
              id
            }
          }
        `,
        variables: {},
        updater: (store, data) => {
          if (data?.newNotification) {
            const { newNotification } = data;

            const notifications = store.get('notifications');
            console.log(notifications);
            if (notifications) {
            }
          }

          const newNotification = store.getRootField('newNotification');
          if (!newNotification) {
            return;
          }

          const notificationsProxy =
            store.getRoot().getLinkedRecords('notifications') || [];
          const newNotificationId = newNotification.getValue('id') as string;

          // Prevent duplicates
          if (
            notificationsProxy.some(
              (notif) => notif.getValue('id') === newNotificationId,
            )
          ) {
            return;
          }

          const updatedNotifications = [newNotification, ...notificationsProxy];
          store
            .getRoot()
            .setLinkedRecords(updatedNotifications, 'notifications');
        },
        ...options,
      }),
      [options],
    );

  return useSubscription(config);
}

export { useNotificationSubscription };
