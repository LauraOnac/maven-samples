package com.benchmarks.tests.order_tests;

import com.benchmarks.states.order_states.Order;
import com.benchmarks.states.order_states.RepoState;
import com.benchmarks.states.order_states.SizeState;
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
public class TestRemoveOrder {

    @State(Scope.Benchmark)
    public static class BeforeState {
        public Order order;

        @Setup(Level.Invocation)
        public void generateOrder(SizeState sizeState) {
            order = sizeState.before.get();
        }
    }

    @State(Scope.Benchmark)
    public static class ExistingState {
        public Order order;

        @Setup(Level.Invocation)
        public void generateOrder(SizeState sizeState) {
            order = sizeState.existing.get();
        }
    }

    @State(Scope.Benchmark)
    public static class AfterState {
        public Order order;

        @Setup(Level.Invocation)
        public void generateOrder(SizeState sizeState) {
            order = sizeState.after.get();
        }
    }

    @Benchmark
    public void removeBefore(RepoState repoState, BeforeState before, Blackhole blackhole) {
        repoState.orders.remove(before.order);
        blackhole.consume(repoState.orders);
    }

    @Benchmark
    public void removeExisting(RepoState repoState, ExistingState existing, Blackhole blackhole) {
        repoState.orders.remove(existing.order);
        blackhole.consume(repoState.orders);
    }

    @Benchmark
    public void removeAfter(RepoState repoState, AfterState after, Blackhole blackhole) {
        repoState.orders.remove(after.order);
        blackhole.consume(repoState.orders);
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(TestRemoveOrder.class.getSimpleName())
//                .jvmArgs("-Xms3048m", "-Xmx3048m", "-XX:+UseG1GC")
//                .addProfiler(HotspotMemoryProfiler.class)
//                .forks(1)
                .build();

        new Runner(opt).run();
    }
}
