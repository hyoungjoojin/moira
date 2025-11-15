import { cn } from '@/utils/cn';

interface SpinnerProps {
  className?: string;
}

function Spinner({ className }: SpinnerProps) {
  return (
    <div
      className={cn(
        'w-4 h-4 border-[2px] border-black border-b-transparent rounded-full animate-spin',
        className,
      )}
    />
  );
}

export default Spinner;
