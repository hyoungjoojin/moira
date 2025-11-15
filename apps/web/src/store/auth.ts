import { produce } from 'immer';
import { create } from 'zustand';

interface User {
  id: string;
}

interface AuthState {
  user: User | null;
}

interface AuthActions {
  setUser: (user: User | null) => void;
}

interface AuthSlice {
  state: AuthState;
  actions: AuthActions;
}

const initialState: AuthState = {
  user: null,
};

const useAuthStore = create<AuthSlice>((set) => ({
  state: initialState,
  actions: {
    setUser: (user) => {
      set(
        produce((state: AuthSlice) => {
          state.state.user = user;
        }),
      );
    },
  },
}));

const useAuth = () => {
  const {
    state: { user },
  } = useAuthStore();

  return { user };
};

const useAuthActions = () => {
  const { actions } = useAuthStore();
  return { ...actions };
};

export { useAuth, useAuthActions };
