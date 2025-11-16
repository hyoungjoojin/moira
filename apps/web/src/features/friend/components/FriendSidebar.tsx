import Button from '@/components/ui/button';
import Input from '@/components/ui/input';
import Separator from '@/components/ui/separator';
import { useSidebar, useSidebarActions } from '@/store/sidebar';
import { useNavigate } from '@tanstack/react-router';

function FriendSidebar() {
  const { open } = useSidebar();

  if (open) {
    return (
      <div>
        <SearchButton open={open} />

        <div className='py-3'>
          <AddFriendButton />
        </div>
      </div>
    );
  } else {
    return (
      <div className='flex flex-col'>
        <SearchButton open={open} />
        <ListButton />

        <Separator />
      </div>
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

function AddFriendButton() {
  const navigate = useNavigate();

  return (
    <Button
      variant='outline'
      icon='add-friend'
      onClick={() => navigate({ to: '/friends/add' })}
    >
      Add Friend
    </Button>
  );
}

function ListButton() {
  const { openSidebar } = useSidebarActions();

  return <Button variant='icon' icon='list' onClick={openSidebar} />;
}

export default FriendSidebar;
