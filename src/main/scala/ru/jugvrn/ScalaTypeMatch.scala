package ru.jugvrn

import org.openjdk.jmh.annotations.{Benchmark, Setup, State, Scope}

/**
 * Created by shutty on 12/25/14.
 */
@State (Scope.Benchmark)
class ScalaTypeMatch {
  sealed trait I
  class Foo extends I
  class Bar extends I
  class Baz extends I

  var value:I = _

  @Setup
  def prepare() = {
    value = new Baz()
  }

  @Benchmark
  def pattern = value match {
    case _:Foo => 1
    case _:Bar => 2
    case _:Baz => 3
    case _ => 4
  }
}
