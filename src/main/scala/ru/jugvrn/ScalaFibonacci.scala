package ru.jugvrn

/**
 * Created by shutty on 1/31/15.
 */

import java.util.concurrent.TimeUnit

import org.openjdk.jmh.annotations._
import scala.annotation.tailrec
import scala.util.Random

@State(Scope.Benchmark)
@BenchmarkMode(Array(Mode.AverageTime))
@OutputTimeUnit(TimeUnit.NANOSECONDS)
class ScalaFibonacci {

  @Param(Array("10","20","40"))
  var N:Int = _

  @CompilerControl(CompilerControl.Mode.DONT_INLINE)
  @tailrec
  private final def fibonacciTCO(prev:Int, curr:Int, n:Int):Int = {
    if (n == 3)
      prev + curr
    else
      fibonacciTCO(curr, prev+curr, n-1)
  }

  @Benchmark
  def measureTCO() = {
    fibonacciTCO(0, 1, N)
  }
}
