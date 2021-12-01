#!/usr/bin/env sh
my_dir=`pwd`
docker run --rm -it -p 8080:8080 \
  -v  $my_dir/:/data/project/ \
  -v  $my_dir/build/qodana/:/data/results/ \
jetbrains/qodana-jvm --show-report
