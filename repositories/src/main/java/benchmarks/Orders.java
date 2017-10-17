package benchmarks;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import repos.ArrayListBasedRepository;
import repos.InMemoryRepository;
import repos.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;
import java.util.stream.Stream;


/**
 * Created by Laura on 10/17/2017.
 */

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Warmup(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 10, time = 1, timeUnit = TimeUnit.SECONDS)
@Fork(1)
@State(Scope.Benchmark)
public class Orders {

    @State(Scope.Thread)
    public static class MyState {
        public InMemoryRepository<Order> arrayListBasedRepository;
        public Order order;

        @Setup(Level.Trial)
        public void doSetup(){
            arrayListBasedRepository = new ArrayListBasedRepository<>();
            order = new Order(1,10,20);
        }

        @TearDown
        public void doTearDown(){}
    }

    @Benchmark
    public InMemoryRepository<Order> addToArrayListBasedRepository(MyState state){
        Order order1 = new Order(1,10,20);
        Order order2 = new Order(2,15,25);
        Order order3 = new Order(3,20,30);
        InMemoryRepository<Order> arrayListBasedRepository = new ArrayListBasedRepository<>();
        arrayListBasedRepository.add(order1);
        arrayListBasedRepository.add(order2);
        arrayListBasedRepository.add(order3);
        return arrayListBasedRepository;
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(Orders.class.getSimpleName())
//                .addProfiler(HotspotMemoryProfiler.class)
                .forks(1)
                .build();

        new Runner(opt).run();
    }
}
