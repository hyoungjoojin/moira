import { cn } from '@/utils/cn';
import React from 'react';

export interface InputProps
  extends React.InputHTMLAttributes<HTMLInputElement> {
  icon?: React.ReactNode;
  className?: string;
}

const Input = React.forwardRef<HTMLInputElement, InputProps>(
  ({ className, icon, ...props }, ref) => {
    return (
      <div className={cn('relative w-full', className)}>
        {icon && (
          <div className='absolute inset-y-0 left-0 pl-3 flex items-center pointer-events-none'>
            {icon}
          </div>
        )}
        <input
          ref={ref}
          className={cn(
            'w-full px-3 py-2 border rounded focus:outline-none focus:ring',
            icon ? 'pl-10' : '',
          )}
          {...props}
        />
      </div>
    );
  },
);
Input.displayName = 'Input';

export default Input;
