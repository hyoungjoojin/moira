import React from 'react';

type ButtonProps = React.ComponentProps<'button'> & {
  children: React.ReactNode;
  isPending?: boolean;
};

function Button({ children, isPending = false }: ButtonProps) {
  return (
    <button>
      {isPending && <span>Wait</span>}
      {children}
    </button>
  );
}

export default Button;
