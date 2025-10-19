import Button from '.';
import type { Meta, StoryObj } from '@storybook/react-vite';
import { fn } from 'storybook/test';

const meta: Meta<typeof Button> = {
  title: 'moira/Button',
  component: Button,
  args: {
    onClick: fn(),
    children: 'Button',
  },
};

type Story = StoryObj<typeof meta>;

const Primary: Story = {
  parameters: {},
};

export default meta;
export { Primary };
