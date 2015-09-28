package ru.jugvrn;

import org.openjdk.jmh.annotations.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by shutty on 9/22/15.
 */
@State(Scope.Benchmark)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)

public class Java8Squares {
    @Param({"100", "1000", "10000"})
    public int SIZE;

    public List<Integer> list;
    public Stream<Integer> stream;
    public IntStream intStream;

    @Setup(Level.Invocation)
    public void prepare() {
        list = new ArrayList<>();
        Random random = new Random();
        for (int i=0; i<SIZE; i++) {
            int value = random.nextInt(2);
            list.add(value);
        }
        stream = list.stream();
        intStream = list.stream().mapToInt(Integer::intValue);
    }

    @Benchmark
    public long streamReduce() {
        return stream.reduce(0, (part, next) -> part + next * next);
    }

    @Benchmark
    public long intStreamReduce() {
        return intStream.reduce(0, (part, next) -> part + next * next);
    }
}
