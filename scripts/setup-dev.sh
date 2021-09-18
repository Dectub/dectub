#!/usr/bin/env sh

if ! (docker run --name dectub.db -e POSTGRES_PASSWORD=1234 -p 22040:5432 -d postgres:11); then
  echo "Failed to start database service"
  exit 1
fi
sleep 1
if ! (docker exec -it dectub.db createdb -U postgres -O postgres dectub); then
  echo "Failed to start database service"
  exit 1
fi
if ! (docker run --name dectub.redis -p 22050:6379 -d redis:6.2.5); then
  echo "Failed to start database service"
  exit 1
fi
if ! (./scripts/setup-git.sh); then
  echo "Failed to init git hooks"
  exit 1
fi
echo "Dev environment setup completed, enjoy please!"
