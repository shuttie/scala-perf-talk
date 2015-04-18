package ru.jugvrn

import java.util.concurrent.TimeUnit

import org.openjdk.jmh.annotations._
import scala.util.Random
import debox.Buffer


/**
 * Created by shutty on 2/3/15.
 */
@State(Scope.Benchmark)
@BenchmarkMode(Array(Mode.AverageTime))
@OutputTimeUnit(TimeUnit.NANOSECONDS)
class ScalaPrimSquares {
  @Param(Array("100", "1000", "10000"))
  var SIZE:Int = _

  var buffer:Buffer[Int] = Buffer.empty
  var array:Array[Int] = _


  @Setup
  def prepare = {
    array = (0 to SIZE).map(x => Random.nextInt(2)).toArray
    buffer.prependAll(array)
  }

  @Benchmark
  def baseline = 1

  @Benchmark
  def squaresDebox:Long = {
    var sum:Long = 0
    buffer.foreach(value => sum += value*value)
    sum
  }

  @Benchmark
  def squaresArrayFold:Long = {
    array.fold(0)((acc,curr) => acc + curr*curr)
  }

  @Benchmark
  def squaresArrayNaive:Long = {
    var sum:Long = 0
    var i = 0
    while (i < array.length) {
      sum += array(i)*array(i)
      i += 1
    }
    sum
  }
}
