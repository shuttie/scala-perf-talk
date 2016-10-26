package ru.jugvrn

/**
 * Created by shutty on 1/31/15.
 */

import java.util.concurrent.TimeUnit

import org.openjdk.jmh.annotations._
import scala.annotation.tailrec
import scala.util.Random

@State(Scope.Benchmark)
@BenchmarkMode(Array(Mode.AverageTime))
@OutputTimeUnit(TimeUnit.NANOSECONDS)
class ScalaFibonacci {

  @Param(Array("10","20","40"))
//  @Param(Array("10","11","12","13","14","15","16","17","18","19","20"))
  var N:Int = _

  @CompilerControl(CompilerControl.Mode.DONT_INLINE)
  @tailrec
  private def fibonacciTailRec(n: Int, a:Int, b:Int):Int = n match {
    case 0 => a
    case _ => fibonacciTailRec(n-1, b, a+b)
  }

  @CompilerControl(CompilerControl.Mode.DONT_INLINE)
  def fibonacciRec(n:Int, a:Int, b:Int):Int = n match {
    case 0 => a
    case _ => fibonacciRec(n-1, b, a+b)
  }


  //@CompilerControl(CompilerControl.Mode.DONT_INLINE)
  def fibonacciLoop(n:Int):Int = {
    var a: Int = 0
    var b: Int = 1
    var i: Int = 0
    while (i < n) {
      val sum = a + b
      a = b
      b = sum
      i += 1
    }
    a
  }

  def fibonacciTCOUnroll(n: Int, a: Int, b: Int): Int = {
    if (n == 0) {
      a
    } else if (n>16) {
      val f1 = a + b
      val f2 = f1 + b
      val f3 = f2 + f1
      val f4 = f3 + f2
      val f5 = f4 + f3
      val f6 = f5 + f4
      val f7 = f6 + f5
      val f8 = f7 + f6
      val f9 = f8 + f7
      val f10 = f9 + f8
      val f11 = f10 + f9
      val f12 = f11 + f10
      val f13 = f12 + f11
      val f14 = f13 + f12
      val f15 = f14 + f13
      val f16 = f15 + f14
      fibonacciTCOUnroll(n - 16, f15, f16)
    } else {
      fibonacciTCOUnroll(n - 1, b, a+b)
    }
  }

  @Benchmark
  def measureTailRec() = {
    fibonacciTailRec(N, 0, 1)
  }

  @Benchmark
  def measureRec() = {
    fibonacciRec(N, 0, 1)
  }

  @Benchmark
  def measureLoop() = {
    fibonacciLoop(N)
  }
}
