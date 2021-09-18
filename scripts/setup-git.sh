#!/usr/bin/env sh
mkdir -p .git/hooks
rm -f .git/hooks/pre-push
cp ./scripts/pre-push .git/hooks/pre-push

