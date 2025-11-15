import Button from '@/components/ui/button';
import Input from '@/components/ui/input';
import { useSidebar, useSidebarActions } from '@/store/sidebar';
import { useNavigate } from '@tanstack/react-router';

function AddFriendSidebar() {
  const { open } = useSidebar();

  if (open) {
    return (
      <div>
        <BackButton open={open} />
        <SearchButton open={open} />
      </div>
    );
  } else {
    return (
      <div>
        <BackButton open={open} />
        <SearchButton open={open} />
      </div>
    );
  }
}

function BackButton({ open }: { open: boolean }) {
  const navigate = useNavigate();

  function backButtonClickHandler() {
    navigate({ to: '/friends' });
  }

  if (open) {
    return (
      <Button
        variant='ghost'
        icon='back'
        onClick={backButtonClickHandler}
        className={open ? 'self-start' : 'mx-auto'}
      >
        Back to friends
      </Button>
    );
  } else {
    return (
      <Button
        variant='icon'
        icon='back'
        onClick={backButtonClickHandler}
        className={open ? 'self-start' : 'mx-auto'}
      />
    );
  }
}

function SearchButton({ open }: { open: boolean }) {
  const { openSidebar } = useSidebarActions();

  return open ? (
    <Input icon='search' type='text' placeholder='Search friends' />
  ) : (
    <Button variant='icon' icon='search' onClick={openSidebar} />
  );
}

export default AddFriendSidebar;
