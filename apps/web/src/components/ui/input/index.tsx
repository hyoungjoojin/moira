import Icon, { type IconType } from '@/components/ui/icon';
import Spinner from '@/components/ui/spinner';
import { cn } from '@/utils/cn';
import React from 'react';

type InputProps = React.ComponentProps<'input'> & {
  icon?: IconType;
  pending?: boolean;
};

function Input({
  className,
  type,
  icon,
  pending = false,
  ...props
}: InputProps) {
  return (
    <div
      className={cn(
        'flex items-center rounded-md bg-transparent text-base shadow-sm transition-colors file:border-0 file:bg-transparent file:text-sm file:font-medium file:text-foreground focus-visible:outline-none disabled:cursor-not-allowed disabled:opacity-50 md:text-sm',
        'py-2 px-2',
      )}
    >
      {icon && (pending ? <Spinner /> : <Icon icon={icon} />)}
      <input
        type={type}
        data-slot='input'
        autoFocus
        disabled={pending}
        className={cn(
          'flex w-full px-3 py-1',
          'placeholder:text-foreground-muted',
          'focus:ring-0 focus:outline-none focus-visible:ring-0',
          className,
        )}
        {...props}
      />
    </div>
  );
}
Input.displayName = 'Input';

export default Input;
