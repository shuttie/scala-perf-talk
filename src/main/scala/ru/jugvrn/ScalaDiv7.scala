package ru.jugvrn


import org.openjdk.jmh.annotations._
import scala.collection.mutable
import scala.util.Random
import scala.collection.optimizer._


/**
 * Created by shutty on 11/30/14.
 */
@State(Scope.Benchmark)
class ScalaDiv7 {
  val SIZE = 10000
  val div = 7

  var list:List[Int] = _
  var arrayBuffer:mutable.ArrayBuffer[Int] = _
  val lambda = (n:Int) => n % div == 0

  @Setup
  def prepare = {
    list = (0 to SIZE).map(x => Random.nextInt()).toList
    arrayBuffer = mutable.ArrayBuffer(list: _*)
  }

  @Benchmark
  def measureList = {
    list.count(_ % div == 0)
  }

  @Benchmark
  def measureLabmdaList = {
    list.count(lambda)
  }

  @Benchmark
  def measureArrayBuffer = {
    arrayBuffer.count(lambda)
  }
}
