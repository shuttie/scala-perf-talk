#!/bin/bash

sbt "jmh:run -wi 5 -i 5 -f 1 -prof perfasm -p N=16 ru.jugvrn.ScalaFibonacci.measureTailRec"