package ru.jugvrn;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;

/**
 * Created by shutty on 12/25/14.
 */
@State(Scope.Benchmark)
public class JavaTypeMatch {
    interface I {};
    class Foo implements I {};
    class Bar implements I {};
    class Baz implements I {};

    I value = null;

    @Setup
    public void prepare() {
        value = new Baz();
    }

    @Benchmark
    public int matchType() {
        if (value instanceof Foo)
            return 1;
        else if (value instanceof Bar)
            return 2;
        else if (value instanceof Baz)
            return 3;
        else
            return 4;
    }

}
