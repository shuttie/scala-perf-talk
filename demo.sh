#!/bin/bash

sbt "jmh:run -wi 3 -i 3 -f 1 ru.jugvrn.Demo.*"