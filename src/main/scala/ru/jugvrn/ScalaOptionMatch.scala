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
  var noneString:Option[String] = _
  var nullableString:String = _
  var nullString:String = _

  @Setup
  def setup() = {
    someString = Some("hello")
    noneString = None
    nullableString = "hello"
    nullString = null
  }

  @Benchmark
  def measureMatchOptionNonempty() = someString match {
    case Some(str) => str
    case None => "empty"
  }

  @Benchmark
  def measureMatchOptionEmpty() = noneString match {
    case Some(str) => str
    case None => "empty"
  }

  @Benchmark
  def measureIfNullNonempty() = if (nullableString != null)
    nullableString
  else
    "empty"

  @Benchmark
  def measureIfNullEmpty = if (nullableString != null)
    nullableString
  else
    "empty"
}
