#!/usr/bin/env sh

# Write some scripts in this place.

if ! (./scripts/setup-git.sh); then
  echo "Failed to init git hooks"
  exit 1
fi
echo "Dev environment setup completed, enjoy please!"
