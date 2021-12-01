#!/usr/bin/env sh
docker run --rm -it -p 8080:8080 \
  -v $(pwd)/:/data/project/ \
  -v $(pwd)/build/qodana/:/data/results/ \
  jetbrains/qodana-jvm --show-report
