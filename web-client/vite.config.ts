import { defineConfig } from "vite";
import react from "@vitejs/plugin-react";

// https://vite.dev/config/
export default defineConfig({
  plugins: [
    react({
      babel: { plugins: ["relay"] },
    }),
  ],
  server: {
    allowedHosts: ["hyoungjoo-3000.run.goorm.io"],
  },
});
