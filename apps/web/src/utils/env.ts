import { createEnv } from '@t3-oss/env-core';
import { z } from 'zod';

const env = createEnv({
  clientPrefix: 'VITE_',
  client: {
    VITE_MOIRA_SERVER_HTTP_URL: z.string().nonempty(),
    VITE_MOIRA_SERVER_WS_URL: z.string().nonempty(),
  },
  runtimeEnv: import.meta.env,
});

export default env;
