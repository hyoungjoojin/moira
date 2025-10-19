import { createEnv } from "@t3-oss/env-core";
import { z } from "zod";

const env = createEnv({
  clientPrefix: "VITE_",
  client: {
    VITE_MOIRA_SERVER_URL: z.string(),
  },
  runtimeEnv: import.meta.env,
});

export default env;
