import { useNotificationSubscription } from '../hooks';
import Button from '@/components/ui/button';
import type { NotificationBellNotificationsQuery } from '@generated/relay/NotificationBellNotificationsQuery.graphql';
import { Bell } from '@mynaui/icons-react';
import { graphql, useLazyLoadQuery } from 'react-relay';

function NotificationBell() {
  const data = useLazyLoadQuery<NotificationBellNotificationsQuery>(
    graphql`
      query NotificationBellNotificationsQuery {
        notifications {
          id
        }
      }
    `,
    {},
    {
      fetchKey: 'notifications',
    },
  );

  useNotificationSubscription();

  const { notifications } = data;

  return (
    <Button variant='icon' icon={<Bell />}>
      {notifications && (
        <span className='absolute top-1 right-1 w-2 h-2 bg-red-500 rounded-full'></span>
      )}
    </Button>
  );
}

export default NotificationBell;
