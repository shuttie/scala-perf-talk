package ru.jugvrn;

import org.openjdk.jmh.annotations.*;

import java.lang.reflect.Array;
import java.util.concurrent.TimeUnit;

/**
 * Created by shutty on 1/31/15.
 */
@State(Scope.Benchmark)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class JavaFibonacci {
    @Param({"10","20","40"})
    public int N;

    @CompilerControl(CompilerControl.Mode.DONT_INLINE)
    private int fibonacciRec(int prev, int curr, int n) {
        if (n == 3)
            return prev+curr;
        else
            return fibonacciRec(curr, prev+curr, n-1);
    }

    @Benchmark
    public int measureRecursive() {
        return fibonacciRec(0, 1, N);
    }

    @Benchmark
    public int measureLoop() {
        int prev = 0;
        int curr = 1;
        for (int i=2; i<N; i++) {
            int next = prev+curr;
            prev = curr;
            curr = next;
        }
        return curr;
    }

}
