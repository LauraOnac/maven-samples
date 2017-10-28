package com.benchmarks.states.int_states;

import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Supplier;

/**
 * Created by Laura on 10/27/2017.
 */
@State(Scope.Benchmark)
public class IntSizeState {
//    @Param({"1000", "10000"})
//    public int size;

    @Param({"100"})
    public int size;

    public Supplier<Integer> existing = new Supplier<Integer>() {
        private final Random random = new Random();

        @Override
        public Integer get() {
            return random.nextInt(size);
        }
    };

    public Supplier<Integer> before = new Supplier<Integer>() {
        private final AtomicInteger currentSize = new AtomicInteger(size);

        @Override
        public Integer get() {
            return currentSize.decrementAndGet();
        }
    };

    public Supplier<Integer> after = new Supplier<Integer>() {
        private final AtomicInteger currentSize = new AtomicInteger(size);

        @Override
        public Integer get() {
            return currentSize.incrementAndGet();
        }
    };

}
