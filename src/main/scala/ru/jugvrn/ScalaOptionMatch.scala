package ru.jugvrn

import java.util.concurrent.TimeUnit

import org.openjdk.jmh.annotations._

/**
 * Created by shutty on 2/15/15.
 */

@State(Scope.Benchmark)
@BenchmarkMode(Array(Mode.AverageTime))
@OutputTimeUnit(TimeUnit.NANOSECONDS)
class ScalaOptionMatch {
  var someString:Option[String] = _
  var nullableString:String = _

  @Setup
  def setup() = {
    someString = Some("hello")
    nullableString = "hello"
  }

  @Benchmark
  def baseline = {
    1+1
  }

  @Benchmark
  def measureMatchOption() = someString match {
    case Some(str) => str
    case _ => "default value"
  }

  @Benchmark
  def measureIfNull() = if (nullableString != null)
    nullableString
  else
    "default value"

}
