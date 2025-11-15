import { create } from 'zustand';

interface SidebarState {
  open: boolean;
}

interface SidebarActions {
  openSidebar: () => void;
  toggleSidebar: () => void;
}

interface SidebarSlice {
  state: SidebarState;
  actions: SidebarActions;
}

const initialSidebarState: SidebarState = {
  open: false,
};

const useSidebarStore = create<SidebarSlice>((set) => ({
  state: initialSidebarState,
  actions: {
    openSidebar: () => {
      set(() => ({
        state: {
          open: true,
        },
      }));
    },
    toggleSidebar: () => {
      set((state) => ({
        state: {
          open: !state.state.open,
        },
      }));
    },
  },
}));

const useSidebar = () => {
  const {
    state: { open },
  } = useSidebarStore();

  return { open };
};

const useSidebarActions = () => {
  const { actions } = useSidebarStore();
  return { ...actions };
};

export { useSidebar, useSidebarActions };
