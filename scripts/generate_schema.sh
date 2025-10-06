#!/usr/bin/env bash

source .envrc

cd apps/graphql

echo "[*] Installing node modules"
pnpm install

echo "[*] Building project"
pnpm run build

echo "[*] Generating schema"
pnpm run generate \
  "$PROJECT_DIRECTORY/docs/graphql" \
  "$PROJECT_DIRECTORY/apps/server/src/main/resources/schema"
