package ru.jugvrn;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by shutty on 11/30/14.
 */
@State(Scope.Benchmark)
public class JavaCollectionsBench {

    public int SIZE = 100;
    public int LENGTH = 2;
    public int[] array = new int[SIZE];
    public List<Integer> list = new ArrayList<>();

    @Setup
    public void prepare() {
        Random random = new Random();
        for (int i=0; i<SIZE; i++) {
            int value = random.nextInt();
            list.add(value);
            array[i] = value;

        }
    }

    @Benchmark
    public int baseline() {
        return 100;
    }

    @Benchmark
    public int baselineArray() {
        int sum = 0;
        for (int item: array) {
            if (item % 2 == 0)
                sum++;
        }
        return sum;
    }
    @Benchmark
    public int baselineList() {
        int sum = 0;
        for (Integer item: list) {
            if (item % 2 == 0)
                sum++;
        }
        return sum;
    }

    @Benchmark
    public long lambda() {
        return list.stream().filter(p -> p % 2 == 0).count();
    }
}
