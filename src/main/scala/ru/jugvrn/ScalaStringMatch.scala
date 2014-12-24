package ru.jugvrn

import org.openjdk.jmh.annotations.{Benchmark, Setup, State, Scope}

/**
 * Created by shutty on 12/25/14.
 */
@State (Scope.Benchmark)
class ScalaStringMatch {
  var line = ""
  @Setup
  def prepare = {
    line = "foo"
  }

  @Benchmark
  def pattern = line match {
    case "bar" => 1
    case "baz" => 2
    case "foo" => 3
    case _ => 4
  }
}
