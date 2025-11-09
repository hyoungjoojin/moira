import { cn } from '@/utils/cn';
import React from 'react';

type ButtonVariant = 'primary' | 'icon';

type ButtonProps = React.ComponentProps<'button'> & {
  variant?: ButtonVariant;
  icon?: React.ReactNode;
  children?: React.ReactNode;
  isPending?: boolean;
  className?: string;
};

function getButtonClasses(variant: ButtonVariant) {
  const defaultClasses =
    'relative p-2 rounded-full hover:bg-slate-100 hover:cursor-pointer ';

  switch (variant) {
    case 'primary':
      return defaultClasses + 'bg-blue-600 text-white hover:bg-blue-700';
    case 'icon':
      return defaultClasses + '';
  }
}

function Button({
  variant = 'primary',
  icon,
  children,
  isPending = false,
  className,
  ...props
}: ButtonProps) {
  return (
    <button
      className={cn(getButtonClasses(variant), className)}
      disabled={isPending}
      {...props}
    >
      {isPending && <span>Wait</span>}
      {icon}
      {children}
    </button>
  );
}

export default Button;
