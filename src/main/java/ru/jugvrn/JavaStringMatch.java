package ru.jugvrn;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;

/**
 * Created by shutty on 12/25/14.
 */
@State(Scope.Benchmark)
public class JavaStringMatch {
    String line = "";

    @Setup
    public void prepare() {
        line = "foo";
    }

    @Benchmark
    public int matchIf() {
        if (line.equals("bar")) {
            return 1;
        } else if (line.equals("baz")) {
            return 2;
        } else if (line.equals("foo")) {
            return 3;
        } else {
            return 4;
        }
    }

    @Benchmark
    public int matchSwitch() {
        switch (line) {
            case "bar": return 1;
            case "baz": return 2;
            case "foo": return 3;
            default: return 4;
        }
    }
}
