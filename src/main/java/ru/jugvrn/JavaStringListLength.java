package ru.jugvrn;

import org.openjdk.jmh.annotations.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by shutty on 4/15/15.
 */
@State(Scope.Benchmark)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class JavaStringListLength {

    @Param({"100", "1000", "10000"})
    public int SIZE;

    List<String> list = null;
    @Setup
    public void setup() {
        list = new ArrayList<>(SIZE);
        for (int i=0; i<SIZE; i++) {
            list.add(i, randomString());
        }
    }

    @Benchmark
    public int imperative() {
        int counter = 0;
        for (String item: list) {
            counter += item.length();
        }
        return counter;
    }

    static String dic = "0123456789abcdef";
    static Random rnd = new Random();
    static String randomString() {
        int length = 1 + rnd.nextInt(128);
        StringBuilder builder = new StringBuilder();
        for (int i=0; i<length; i++) {
            builder.append(dic.charAt(rnd.nextInt(dic.length())));
        }
        return builder.toString();
    }
}
