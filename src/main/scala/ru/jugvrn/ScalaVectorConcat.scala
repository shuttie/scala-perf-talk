package ru.jugvrn

import java.util.concurrent.TimeUnit

import org.openjdk.jmh.annotations._

/**
 * Created by shutty on 8/25/15.
 */
@State (Scope.Benchmark)
@BenchmarkMode(Array(Mode.AverageTime))
@OutputTimeUnit(TimeUnit.NANOSECONDS)
class ScalaVectorConcat {
  @Param(Array("32", "64", "128", "256", "512", "1024", "2048", "4096", "8192", "16384", "32768", "65536"))
  var length:String = _
  var vector1:Vector[Int] = _
  var vector2:Vector[Int] = _

  @Setup
  def setup() = {
    vector1 = Vector.fill(length.toInt)(0)
    vector2 = Vector.fill(length.toInt)(0)
  }

  @Benchmark
  def concat = {
    vector1 ++ vector2
  }
}
