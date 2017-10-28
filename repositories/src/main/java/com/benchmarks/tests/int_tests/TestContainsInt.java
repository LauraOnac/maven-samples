package com.benchmarks.tests.int_tests;

import com.benchmarks.states.int_states.IntRepoState;
import com.benchmarks.states.int_states.IntSizeState;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

/**
 * Created by Laura on 10/27/2017.
 */
@BenchmarkMode(Mode.Throughput)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Warmup(iterations = 10, time = 1)
@Measurement(iterations = 20, time = 1)
@Fork(2)
public class TestContainsInt {

    @State(Scope.Benchmark)
    public static class BeforeState {
        public int number;

        @Setup(Level.Invocation)
        public void generateOrder(IntSizeState sizeState) {
            number = sizeState.before.get();
        }
    }

    @State(Scope.Benchmark)
    public static class ExistingState {
        public int number;

        @Setup(Level.Invocation)
        public void generateOrder(IntSizeState sizeState) {
            number = sizeState.existing.get();
        }
    }

    @State(Scope.Benchmark)
    public static class AfterState {
        public int number;

        @Setup(Level.Invocation)
        public void generateOrder(IntSizeState sizeState) {
            number = sizeState.after.get();
        }
    }

    @Benchmark
    public void containsBefore(IntRepoState repoState, BeforeState before, Blackhole blackhole) {
        blackhole.consume(repoState.numbers.contains(before.number));
    }

    @Benchmark
    public void containsExisting(IntRepoState repoState, ExistingState existing, Blackhole blackhole) {
        blackhole.consume(repoState.numbers.contains(existing.number));
    }

    @Benchmark
    public void containsAfter(IntRepoState repoState, AfterState after, Blackhole blackhole) {
        blackhole.consume(repoState.numbers.contains(after.number));
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(TestContainsInt.class.getSimpleName())
//                .jvmArgs("-Xms3048m", "-Xmx3048m", "-XX:+UseG1GC")
//                .addProfiler(HotspotMemoryProfiler.class)
//                .forks(1)
                .build();

        new Runner(opt).run();
    }
}
