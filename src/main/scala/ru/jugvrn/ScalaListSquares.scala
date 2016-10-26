package ru.jugvrn

import java.util.concurrent.TimeUnit

import org.openjdk.jmh.annotations._

import scala.util.Random
/**
  * Created by shutty on 10/16/16.
  */
@State(Scope.Benchmark)
@BenchmarkMode(Array(Mode.AverageTime))
@OutputTimeUnit(TimeUnit.NANOSECONDS)
class ScalaListSquares {
  @Param(Array("100", "1000", "10000"))
  var SIZE:Int = _
  var list:List[Long] = _
  var array:Array[Long] = _

  @Setup
  def prepare = {
    list = (0 to SIZE).map(x => Random.nextLong() % 128L).toList
    array = list.toArray
  }

  @Benchmark
  def foldList:Long = {
    list.foldLeft(0L)( (part,next) => part + next*next)
  }

  @Benchmark
  def foldArray:Long = {
    array.foldLeft(0L)( (part,next) => part + next*next)
  }

/*  @Benchmark
  def mapSum:Long = {
    list.map(x => x*x).sum
  }
*/
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

  @Benchmark
  def baseline:Long = {
    var i = 0
    var sum = 0L
    while (i<SIZE) {
      sum += array(i) * array(i)
      i += 1
    }
    sum
  }
}
