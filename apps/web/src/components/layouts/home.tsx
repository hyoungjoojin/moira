import { type IconType } from '../ui/icon';
import Sidebar, { ToggleSidebarButton } from './sidebar';
import Button from '@/components/ui/button';
import UserAvatar from '@/features/user/components/UserAvatar';
import { cn } from '@/utils/cn';
import type { FileRouteTypes } from '@generated/router/tree';
import { useLocation, useNavigate } from '@tanstack/react-router';

interface HomeLayoutProps {
  children?: React.ReactNode;
}

const tabs: {
  icon: IconType;
  to: FileRouteTypes['fullPaths'];
}[] = [
  {
    icon: 'friends',
    to: '/friends',
  },
  {
    icon: 'squads',
    to: '/squads',
  },
  {
    icon: 'notifications',
    to: '/notifications',
  },
];

function HomeLayout({ children }: HomeLayoutProps) {
  return (
    <div className='flex'>
      <Header />

      <div className='grow flex'>
        <nav>
          <Sidebar />
        </nav>

        <Main>{children}</Main>
      </div>
    </div>
  );
}

function Header() {
  const pathname = useLocation({
    select: (location) => location.pathname,
  });
  const navigate = useNavigate();

  return (
    <header
      className={cn(
        'flex flex-col items-center justify-between h-screen pb-10 bg-background-inverted',
        'px-4 pt-5 w-20 border-r border-background/20',
      )}
    >
      <div className='flex flex-col items-center gap-10'>
        <div>
          <h1 className='text-xl font-bold text-background'>m.</h1>
        </div>

        <div className='flex flex-col items-center gap-3'>
          {tabs.map(({ icon, to }, index) => (
            <Button
              key={index}
              variant='icon'
              icon={icon}
              invert
              disabled={pathname.startsWith(to)}
              onClick={() => navigate({ to })}
              className={cn(pathname.startsWith(to) && 'bg-background/10')}
            />
          ))}
        </div>
      </div>

      <div className='flex flex-col items-center gap-5'>
        <ToggleSidebarButton />
        <UserAvatar />
      </div>
    </header>
  );
}

interface MainProps {
  children?: React.ReactNode;
}

function Main({ children }: MainProps) {
  return <main className='grow'>{children}</main>;
}

export default HomeLayout;
