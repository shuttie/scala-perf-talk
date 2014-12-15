package ru.jugvrn


import org.openjdk.jmh.annotations._
import org.openjdk.jmh.infra.Blackhole


/**
 * Created by shutty on 11/30/14.
 */
@State(Scope.Benchmark)
class ScalaCollectionsBench {
  val SIZE = 100
  val LENGTH = 2
  /*
  val list:List[String] = (for (i <- 0 until SIZE) yield { JavaCollectionsBench.getRandomString(LENGTH) }).toList
  val arr = Array[Int]()

  @Benchmark
  def measureCount() = {
    list.count(_.startsWith("a"))
  }

  @Benchmark
  def measureForeach() = {
    var sum = 0
    list.foreach( item => if (item.startsWith("a")) sum+=1)
    sum
  }

  @Benchmark
  def measureFor() = {
    var sum = 0
    for (i <- 0 to SIZE) if (list(i).startsWith("a")) sum += 1
    sum
  }
*/
}
