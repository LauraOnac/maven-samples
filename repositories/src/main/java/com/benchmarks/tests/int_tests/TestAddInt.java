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
public class TestAddInt {

    @State(Scope.Benchmark)
    public static class BeforeState {
        public int number;

        @Setup(Level.Invocation)
        public void generateNumber(IntSizeState sizeState) {
            number = sizeState.before.get();
        }

        @TearDown(Level.Invocation)
        public void removeNumber(IntRepoState repoState) {
            repoState.numbers.remove(number);
        }
    }

    @State(Scope.Benchmark)
    public static class ExistingState {
        public int number;

        @Setup(Level.Invocation)
        public void generateNumber(IntSizeState sizeState) {
            number = sizeState.existing.get();
        }

        @TearDown(Level.Invocation)
        public void removeNumber(IntRepoState repoState) {
            repoState.numbers.remove(number);
        }
    }

    @State(Scope.Benchmark)
    public static class AfterState {
        public int number;

        @Setup(Level.Invocation)
        public void generateNumber(IntSizeState sizeState) {
            number = sizeState.after.get();
        }

        @TearDown(Level.Invocation)
        public void removeNumber(IntRepoState repoState) {
            repoState.numbers.remove(number);
        }
    }

    @Benchmark
    public void addBefore(IntRepoState repoState, BeforeState before, Blackhole blackhole) {
        repoState.numbers.add(before.number);
        blackhole.consume(repoState.numbers);
    }

    @Benchmark
    public void addExisting(IntRepoState repoState, ExistingState existing, Blackhole blackhole) {
        repoState.numbers.add(existing.number);
        blackhole.consume(repoState.numbers);
    }

    @Benchmark
    public void addAfter(IntRepoState repoState, AfterState after, Blackhole blackhole) {
        repoState.numbers.add(after.number);
        blackhole.consume(repoState.numbers);
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(TestAddInt.class.getSimpleName())
//                .jvmArgs("-Xms3048m", "-Xmx3048m", "-XX:+UseG1GC")
//                .addProfiler(HotspotMemoryProfiler.class)
//                .forks(1)
                .build();

        new Runner(opt).run();
    }
}
