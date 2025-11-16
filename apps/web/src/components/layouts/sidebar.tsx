import Button from '@/components/ui/button';
import AddFriendSidebar from '@/features/friend/components/AddFriendSidebar';
import FriendSidebar from '@/features/friend/components/FriendSidebar';
import { useSidebar, useSidebarActions } from '@/store/sidebar';
import { cn } from '@/utils/cn';
import type { FileRouteTypes } from '@generated/router/tree';
import { useLocation } from '@tanstack/react-router';

const SidebarMap: Partial<
  Record<FileRouteTypes['fullPaths'], React.ReactNode>
> = {
  '/friends': <FriendSidebar />,
  '/friends/$id': <FriendSidebar />,
  '/friends/add': <AddFriendSidebar />,
};

function getSidebar(pathname: string) {
  if (pathname === '/friends/add') {
    return <AddFriendSidebar />;
  }

  if (pathname.startsWith('/friends')) {
    return <FriendSidebar />;
  }

  return null;
}

function Sidebar() {
  const pathname = useLocation({
    select: (location) => location.pathname,
  });

  const { open } = useSidebar();

  const sidebar = getSidebar(pathname);
  if (!sidebar) {
    return null;
  }

  return (
    <div
      className={cn(
        'pt-10 h-screen bg-background',
        open ? 'w-72 px-5' : 'w-16',
        'border-r border-border',
        'transition-width duration-200',
      )}
    >
      {sidebar}
    </div>
  );
}

function ToggleSidebarButton() {
  const pathname = useLocation({
    select: (location) => location.pathname,
  });

  const { toggleSidebar } = useSidebarActions();

  const sidebar = getSidebar(pathname);
  if (!sidebar) {
    return null;
  }

  return (
    <Button variant='icon' icon='sidebar' invert onClick={toggleSidebar} />
  );
}

export default Sidebar;
export { ToggleSidebarButton };
