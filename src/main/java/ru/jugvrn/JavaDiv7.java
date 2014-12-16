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
public class JavaDiv7 {

    public int SIZE = 10000;
    public int div = 7;
    public List<Integer> list = new ArrayList<>();

    @Setup
    public void prepare() {
        Random random = new Random();
        for (int i=0; i<SIZE; i++) {
            int value = random.nextInt();
            list.add(value);
        }
    }

    @Benchmark
    public long measureList() {
        int sum = 0;
        for (Integer item: list) {
            if (item % div == 0)
            sum++;
        }
        return sum;
    }

/*    @Benchmark
    public long measureLambda() {
        return list.stream().filter(p -> p % div == 0).count();
    }*/
}
