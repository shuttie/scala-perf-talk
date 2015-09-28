package ru.jugvrn


import java.util.concurrent.TimeUnit
import scala.collection.optimizer._
import org.openjdk.jmh.annotations._
import scala.util.Random

/**
 * Created by shutty on 9/25/15.
 */
@State(Scope.Benchmark)
@BenchmarkMode(Array(Mode.AverageTime))
@OutputTimeUnit(TimeUnit.NANOSECONDS)
class ScalaBlitzSquares {
  @Param(Array("100", "1000", "10000"))
  var SIZE:Int = _
  var list:Array[Int] = _

  @Setup
  def prepare = {
    list = (0 to SIZE).map(x => Random.nextInt(2)).toArray
  }

  @Benchmark
  def fold = {
    optimize {
      list.fold(0)( (acc, next) => acc +  next*next)
    }
  }
  @Benchmark
  def reduce = {
    optimize {
      list.reduce( (acc, next) => acc +  next*next)
    }
  }

  @Benchmark
  def reduceNoopt = {
    list.reduce( (acc, next) => acc +  next*next)
  }

  @Benchmark
  def imperativeLoop = {
    var i  = 0
    var sum = 0
    while (i<list.length) {
      sum += list(i) * list(i)
      i+=1
    }
    sum
  }

  @Benchmark
  def imperativeIterator = {
    val i = list.iterator
    var sum:Long = 0
    while (i.hasNext) {
      val next = i.next()
      sum += next * next
    }
    sum
  }

}
