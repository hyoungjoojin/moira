import {
  Bell,
  ChevronDoubleLeft,
  Filter,
  Grid,
  Menu,
  type MynaIconsProps,
  Plus,
  Search,
  Sidebar,
  SkipBack,
  User,
  UserPlus,
  Users,
} from '@mynaui/icons-react';
import type { JSX } from 'react';

type IconType =
  | 'user'
  | 'friends'
  | 'squads'
  | 'notifications'
  | 'add'
  | 'add-friend'
  | 'sidebar'
  | 'search'
  | 'list'
  | 'filter'
  | 'back';

type IconProps = {
  icon: IconType;
} & MynaIconsProps;

function Icon({ icon, ...props }: IconProps) {
  const Component = map[icon];
  return <Component {...props} />;
}

const map: Record<IconType, (props: MynaIconsProps) => JSX.Element> = {
  user: User,
  friends: Users,
  squads: Grid,
  notifications: Bell,
  add: Plus,
  'add-friend': UserPlus,
  sidebar: Sidebar,
  search: Search,
  list: Menu,
  filter: Filter,
  back: ChevronDoubleLeft,
};

export default Icon;
export type { IconType };
