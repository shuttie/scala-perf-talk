package ru.jugvrn

import org.openjdk.jmh.annotations._
import java.util.concurrent.TimeUnit

@BenchmarkMode(Array(Mode.AverageTime))
@OutputTimeUnit(TimeUnit.NANOSECONDS)
class Demo {
  @Benchmark
  def helloWorld = 42
}
