import Icon, { type IconType } from '@/components/ui/icon';
import { cn } from '@/utils/cn';
import React from 'react';

type ButtonVariant = 'primary' | 'icon' | 'outline' | 'ghost';

type ButtonProps = React.ComponentProps<'button'> & {
  variant?: ButtonVariant;
  icon?: IconType;
  invert?: boolean;
  children?: React.ReactNode;
  className?: string;
};

function getButtonClasses(variant: ButtonVariant, invert?: boolean) {
  const defaultClasses = cn(
    'relative p-2 rounded-full',
    'flex items-center justify-center gap-2',
    invert ? 'text-background' : 'text-background-inverted',
    invert
      ? 'hover:bg-background/10 hover:cursor-pointer'
      : 'hover:bg-background-inverted/10 hover:cursor-pointer',
  );

  switch (variant) {
    case 'primary':
      return defaultClasses;
    case 'icon':
      return defaultClasses;
    case 'outline':
      return cn(
        defaultClasses,
        'w-full shadow-sm',
        'px-4 py-2',
        'rounded-md',
        'text-sm font-medium',
      );
    case 'ghost':
      return cn(defaultClasses, 'gap-1', 'text-sm');
  }
}

function Button({
  variant = 'primary',
  invert,
  icon,
  children,
  className,
  ...props
}: ButtonProps) {
  return (
    <button
      className={cn(getButtonClasses(variant, invert), className)}
      {...props}
    >
      {icon && <Icon icon={icon} />}
      {children}
    </button>
  );
}

export default Button;
