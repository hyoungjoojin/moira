import Button from '@/components/ui/button';
import NotificationBell from '@/features/notification/components/NotificationBell';
import { cn } from '@/utils/cn';
import type { FileRouteTypes } from '@generated/router/tree';
import { Menu, MessageDots, Users } from '@mynaui/icons-react';
import { useLocation, useNavigate } from '@tanstack/react-router';

interface HomeLayoutProps {
  children?: React.ReactNode;
}

const tabs: {
  label: string;
  icon: React.ReactNode;
  pathname: FileRouteTypes['fullPaths'];
}[] = [
  {
    label: 'Friends',
    icon: <Users />,
    pathname: '/friends',
  },
  {
    label: 'Squads',
    icon: <MessageDots />,
    pathname: '/squads',
  },
  {
    label: 'Menu',
    icon: <Menu />,
    pathname: '/menu',
  },
];

function HomeLayout({ children }: HomeLayoutProps) {
  return (
    <>
      <Header />

      <div className='lg:hidden'>
        <NavBar />
      </div>

      <div>
        <div className='hidden lg:block'>
          <Sidebar />
        </div>

        <Main>{children}</Main>
      </div>
    </>
  );
}

function Header() {
  return (
    <>
      <header className='flex-shrink-0 bg-white shadow-sm border-b border-slate-200 dark:border-slate-700'>
        <div className='max-w-7xl mx-auto px-4 sm:px-6 lg:px-8 py-4'>
          <div className='flex items-center justify-between'>
            <h1 className='text-2xl font-bold'>moira.</h1>
            <div className='flex items-center gap-3'>
              <NotificationBell />
            </div>
          </div>
        </div>
      </header>
    </>
  );
}

function NavBar() {
  const location = useLocation();
  const navigate = useNavigate();

  return (
    <nav className='sticky flex-shrink-0 bg-white dark:bg-slate-800 border-t border-slate-200 dark:border-slate-700 shadow-lg lg:hidden'>
      <div className='max-w-7xl mx-auto px-4 sm:px-6 lg:px-8'>
        <div className='flex justify-around items-center h-20 sm:h-16'>
          {tabs.map((tab, index) => {
            const active = location.pathname === tab.pathname;
            return (
              <Button
                key={index}
                variant='icon'
                icon={tab.icon}
                onClick={() => {
                  navigate({ to: tab.pathname });
                }}
                className={cn(
                  'flex flex-col items-center justify-center gap-1 px-6 py-2 rounded-xl transition-all duration-300 relative group',
                  active
                    ? 'text-blue-600 dark:text-blue-400'
                    : 'text-slate-500 dark:text-slate-400 hover:text-slate-700 dark:hover:text-slate-300',
                )}
              >
                <span
                  className={cn(
                    'text-xs font-medium transition-all duration-300',
                    active ? 'opacity-100 font-semibold' : 'opacity-70',
                  )}
                >
                  {tab.label}
                </span>
                {active && (
                  <div className='absolute -top-1 left-1/2 -translate-x-1/2 w-12 h-1 bg-gradient-to-r from-blue-600 to-purple-600 rounded-full' />
                )}
              </Button>
            );
          })}
        </div>
      </div>
    </nav>
  );
}

function Sidebar() {
  return <aside></aside>;
}

interface MainProps {
  children?: React.ReactNode;
}

function Main({ children }: MainProps) {
  return (
    <main className='flex-1 overflow-hidden h-full p-6'>
      <div className='bg-white dark:bg-slate-800 rounded-2xl shadow-xl h-full flex flex-col overflow-hidden border border-slate-200 dark:border-slate-700'>
        <div className='flex-1 overflow-y-auto p-6'>{children}</div>
      </div>
    </main>
  );
}

export default HomeLayout;
