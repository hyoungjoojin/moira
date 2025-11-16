import {
  Bell,
  ChevronDoubleLeft,
  Dots,
  Filter,
  Grid,
  Heart,
  Menu,
  type MynaIconsProps,
  Plus,
  Search,
  Sidebar,
  User,
  UserCheck,
  UserPlus,
  Users,
  X,
} from '@mynaui/icons-react';
import type { JSX } from 'react';

type IconType =
  | 'user'
  | 'friends'
  | 'squads'
  | 'notifications'
  | 'add'
  | 'add-friend'
  | 'already-friends'
  | 'sidebar'
  | 'search'
  | 'list'
  | 'filter'
  | 'back'
  | 'x'
  | 'heart'
  | 'ellipsis';

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
  'already-friends': UserCheck,
  sidebar: Sidebar,
  search: Search,
  list: Menu,
  filter: Filter,
  back: ChevronDoubleLeft,
  x: X,
  heart: Heart,
  ellipsis: Dots,
};

export default Icon;
export type { IconType };
