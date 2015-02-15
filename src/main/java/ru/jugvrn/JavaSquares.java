package ru.jugvrn;

import org.openjdk.jmh.annotations.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by shutty on 11/30/14.
 */
@State(Scope.Benchmark)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class JavaSquares {

    @Param({"100", "1000", "10000"})
    public int SIZE;

    public List<Integer> list = new LinkedList<>();

    @Setup
    public void prepare() {
        Random random = new Random();
        for (int i=0; i<SIZE; i++) {
            int value = random.nextInt(2);
            list.add(value);
        }
    }

    @Benchmark
    public long squares() {
        long sum = 0;
        for (Integer item: list) {
            sum += item*item;
        }
        return sum;
    }

    @Benchmark
    public long squares_java8() {
        return list.stream().reduce(0, (part,next) -> part + next*next);
    }
}
