package ru.jugvrn;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Created by shutty on 11/30/14.
 */
@State(Scope.Benchmark)
public class JavaSquares {

    public int SIZE = 100000;
    public List<Integer> list = new ArrayList<>();

    @Setup
    public void prepare() {
        Random random = new Random();
        for (int i=0; i<SIZE; i++) {
            int value = random.nextInt(2);
            list.add(value);
        }
    }

    @Benchmark
    public int squares() {
        int sum = 0;
        for (Integer item: list) {
            sum += item*item;
        }
        return sum;
    }

    @Benchmark
    public int squares_java8() {
        return list.stream().reduce(0, (part,next) -> part + next*next);
    }
}
