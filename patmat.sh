#!/bin/bash

sbt "jmh:run -wi 3 -i 3 -f 1 -prof perfasm -p classType=baz ru.jugvrn.ScalaTypeMatch.measurePatternMatch"