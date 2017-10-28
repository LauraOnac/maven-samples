package com.benchmarks.states.int_states;

import com.benchmarks.repos.int_repos.IntInMemoryRepository;
import org.openjdk.jmh.annotations.*;

import java.util.stream.IntStream;

/**
 * Created by Laura on 10/27/2017.
 */
@State(Scope.Benchmark)
public class IntRepoState {
    @Param
    private IntRepositorySupplier intRepositorySupplier;

    public IntInMemoryRepository numbers;

    /* run before each benchmark */
    @Setup
    public void setUp(IntSizeState sizeState) {
        System.out.println(getClass().getSimpleName() + " > setup > populate");
        numbers = intRepositorySupplier.get();

        IntStream.rangeClosed(1, sizeState.size)
                .forEach(numbers::add);
    }

    /* run after each benchmark */
    @TearDown
    public void tearDown() {
        System.out.println(getClass().getSimpleName() + " > teardown > clear");
        numbers.clear();
        System.gc();
    }
}
