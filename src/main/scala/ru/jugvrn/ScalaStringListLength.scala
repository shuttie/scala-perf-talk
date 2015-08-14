package ru.jugvrn

import java.util.concurrent.TimeUnit

import org.openjdk.jmh.annotations._

/**
 * Created by shutty on 4/15/15.
 */
@State(Scope.Benchmark)
@BenchmarkMode(Array (Mode.AverageTime) )
@OutputTimeUnit(TimeUnit.NANOSECONDS)
class ScalaStringListLength {
  @Param(Array("100","1000","10000"))
  var SIZE:Int = _

  var list:Array[String] = _

  @Setup
  def setup = {
    list = (for (i <- 0 to SIZE) yield {JavaStringListLength.randomString()}).toArray
  }

  @Benchmark
  def fold = {
    list.foldLeft(0)((acc,next) => acc + next.length)
  }

  @Benchmark
  def imperative = {
    var i = 0
    var counter = 0
    while (i < list.length) {
      counter += list(i).length
      i += 1
    }
    counter
  }
}
