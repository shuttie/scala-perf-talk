package ru.jugvrn

import java.util.concurrent.TimeUnit

import org.openjdk.jmh.annotations._

import scala.util.Random

/**
 * Created by shutty on 12/25/14.
 */
@State (Scope.Benchmark)
@BenchmarkMode(Array(Mode.AverageTime))
@OutputTimeUnit(TimeUnit.NANOSECONDS)
class ScalaTypeMatch {

  trait Base
  class Foo extends Base
  class Bar extends Base
  class Baz extends Base

  @Param(Array("foo", "bar", "baz"))
  var classType:String = _
  var someClass:Base = _

  @Setup(Level.Iteration)
  def prepare() = {
    someClass = classType match {
      case "foo" => new Foo()
      case "bar" => new Bar()
      case "baz" => new Baz()
    }
  }

  @Benchmark
  def measurePatternMatch = someClass match {
    case _:Foo => 1
    case _:Bar => 2
    case _:Baz => 3
    case _ => 4
  }

  @Benchmark
  def measureIf = if (someClass.isInstanceOf[Foo])
    1
  else if (someClass.isInstanceOf[Bar])
    2
  else if (someClass.isInstanceOf[Baz])
    3
  else
    4

}
