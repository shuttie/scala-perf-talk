package ru.jugvrn


import java.util.concurrent.TimeUnit

import org.openjdk.jmh.annotations._
import scala.util.Random

/**
 * Created by shutty on 11/30/14.
 */


@State(Scope.Benchmark)
@BenchmarkMode(Array(Mode.AverageTime))
@OutputTimeUnit(TimeUnit.NANOSECONDS)
class ScalaSquares {
  @Param(Array("100", "1000", "10000"))
  var SIZE:Int = _
  var list:Array[Int] = _

  @Setup
  def prepare = {
    list = (0 to SIZE).map(x => Random.nextInt(2)).toArray
  }

  @Benchmark
  def fold:Long = {
    list.fold(0)( (part,next) => part + next*next)
  }

  @Benchmark
  def reduce:Long = {
    list.reduce( (part,next) => part + next*next )
  }

  @Benchmark
  def mapSum:Long = {
    list.map(x => x*x).sum
  }

  @Benchmark
  def imperative:Long = {
    val i = list.iterator
    var sum:Long = 0
    while (i.hasNext) {
      val next = i.next()
      sum += next * next
    }
    sum
  }
}
