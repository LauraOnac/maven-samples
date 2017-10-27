package com.benchmarks;

import com.benchmarks.states.RepoState;
import com.benchmarks.states.SizeState;
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
public class TestAdd {

    @State(Scope.Benchmark)
    public static class BeforeState {
        public Order order;

        @Setup(Level.Invocation)
        public void generateOrder(SizeState sizeState) {
            order = sizeState.before.get();
        }

        @TearDown(Level.Invocation)
        public void removeOrder(RepoState repoState) {
            repoState.orders.remove(order);
        }
    }

    @State(Scope.Benchmark)
    public static class ExistingState {
        public Order order;

        @Setup(Level.Invocation)
        public void generateOrder(SizeState sizeState) {
            order = sizeState.existing.get();
        }

        @TearDown(Level.Invocation)
        public void removeOrder(RepoState repoState) {
            repoState.orders.remove(order);
        }
    }

    @State(Scope.Benchmark)
    public static class AfterState {
        public Order order;

        @Setup(Level.Invocation)
        public void generateOrder(SizeState sizeState) {
            order = sizeState.after.get();
        }

        @TearDown(Level.Invocation)
        public void removeOrder(RepoState repoState) {
            repoState.orders.remove(order);
        }
    }

    @Benchmark
    public void addBefore(RepoState repoState, BeforeState before, Blackhole blackhole) {
        repoState.orders.add(before.order);
        blackhole.consume(repoState.orders);
    }

    @Benchmark
    public void addExisting(RepoState repoState, ExistingState existing, Blackhole blackhole) {
        repoState.orders.add(existing.order);
        blackhole.consume(repoState.orders);
    }

    @Benchmark
    public void addAfter(RepoState repoState, AfterState after, Blackhole blackhole) {
        repoState.orders.add(after.order);
        blackhole.consume(repoState.orders);
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(TestAdd.class.getSimpleName()+".*")
//                .jvmArgs("-Xms3048m", "-Xmx3048m", "-XX:+UseG1GC")
//                .addProfiler(HotspotMemoryProfiler.class)
//                .forks(1)
                .build();

        new Runner(opt).run();
    }
}
