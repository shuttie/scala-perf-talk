package ru.jugvrn

import org.openjdk.jmh.annotations._

class Demo {
  @Benchmark
  def helloWorld = 42
}
