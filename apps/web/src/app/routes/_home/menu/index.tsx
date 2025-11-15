import { createFileRoute } from '@tanstack/react-router';

export const Route = createFileRoute('/_home/menu/')({
  component: RouteComponent,
});

function RouteComponent() {
  const menuItems = [
    {
      icon: '👤',
      label: 'Profile Settings',
      description: 'Edit your profile and preferences',
    },
    {
      icon: '🔔',
      label: 'Notifications',
      description: 'Manage notification settings',
    },
    { icon: '🎨', label: 'Appearance', description: 'Customize your theme' },
    {
      icon: '🔒',
      label: 'Privacy & Security',
      description: 'Control your privacy settings',
    },
    {
      icon: '💬',
      label: 'Chat Settings',
      description: 'Manage chat preferences',
    },
    {
      icon: '❓',
      label: 'Help & Support',
      description: 'Get help and contact support',
    },
  ];

  return (
    <div className='flex flex-col h-full'>
      <div className='flex-shrink-0 p-4 sm:p-6 border-b border-slate-200 dark:border-slate-700'>
        <div className='flex items-center gap-4 mb-6'>
          <div className='w-20 h-20 rounded-full bg-gradient-to-br from-blue-600 to-purple-600 flex items-center justify-center text-4xl shadow-lg'>
            👤
          </div>
          <div>
            <h2 className='text-2xl font-bold text-slate-800 dark:text-slate-100'>
              Your Profile
            </h2>
            <p className='text-sm text-slate-500 dark:text-slate-400'>
              user@example.com
            </p>
          </div>
        </div>
      </div>
      <div className='flex-1 overflow-y-auto p-4 space-y-2'>
        {menuItems.map((item, index) => (
          <button
            key={index}
            className='w-full flex items-center gap-4 p-4 rounded-xl hover:bg-slate-50 dark:hover:bg-slate-700/50 transition-colors text-left group'
          >
            <div className='w-12 h-12 rounded-xl bg-gradient-to-br from-slate-100 to-slate-200 dark:from-slate-700 dark:to-slate-600 flex items-center justify-center text-2xl group-hover:scale-110 transition-transform shadow-sm'>
              {item.icon}
            </div>
            <div className='flex-1'>
              <h3 className='font-semibold text-slate-800 dark:text-slate-100'>
                {item.label}
              </h3>
              <p className='text-sm text-slate-500 dark:text-slate-400'>
                {item.description}
              </p>
            </div>
            <svg
              className='w-6 h-6 text-slate-400 group-hover:text-slate-600 dark:group-hover:text-slate-300 transition-colors'
              fill='none'
              stroke='currentColor'
              viewBox='0 0 24 24'
            >
              <path
                strokeLinecap='round'
                strokeLinejoin='round'
                strokeWidth={2}
                d='M9 5l7 7-7 7'
              />
            </svg>
          </button>
        ))}
      </div>
      <div className='flex-shrink-0 p-4 border-t border-slate-200 dark:border-slate-700'>
        <button className='w-full py-3 px-4 bg-red-600 text-white rounded-xl font-semibold shadow-lg hover:shadow-xl transition-shadow hover:bg-red-700'>
          Sign Out
        </button>
      </div>
    </div>
  );
}
