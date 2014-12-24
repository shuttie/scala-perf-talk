package ru.jugvrn


import org.openjdk.jmh.annotations._
import scala.util.Random


/**
 * Created by shutty on 11/30/14.
 */
@State(Scope.Benchmark)
class ScalaSquares {
  val SIZE = 100000

  var list:Array[Int] = _

  @Setup
  def prepare = {
    list = (0 to SIZE).map(x => Random.nextInt(2)).toArray
  }

  @Benchmark
  def squaresFold = {
    list.fold(0)( (part,next) => part + next*next)
  }

  @Benchmark
  def squaresMapSum = {
    list.map(x => x*x).sum
  }
}
