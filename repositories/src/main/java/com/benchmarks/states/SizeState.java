package com.benchmarks.states;

import com.benchmarks.Order;
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
public class SizeState {
//    @Param({"1000", "10000"})
//    public int size;

    @Param({"100"})
    public int size;

    public Supplier<Order> existing = new Supplier<Order>() {
        private final Random random = new Random();

        @Override
        public Order get() {
            int id = random.nextInt(size);
            return new Order(id,id,id);
        }
    };

    public Supplier<Order> before = new Supplier<Order>() {
        private final AtomicInteger currentSize = new AtomicInteger(size);

        @Override
        public Order get() {
            int id = currentSize.decrementAndGet();
            return new Order(id,id,id);
        }
    };

    public Supplier<Order> after = new Supplier<Order>() {
        private final AtomicInteger currentSize = new AtomicInteger(size);

        @Override
        public Order get() {
            int id = currentSize.incrementAndGet();
            return new Order(id,id,id);
        }
    };

}
