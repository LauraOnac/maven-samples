package com.benchmarks.states.order_states;

import com.benchmarks.repos.generic_repos.InMemoryRepository;
import org.openjdk.jmh.annotations.*;

import java.util.stream.IntStream;

/**
 * Created by Laura on 10/26/2017.
 */
@State(Scope.Benchmark)
public class RepoState {
    @Param
    private RepositorySupplier repositorySupplier;

    public InMemoryRepository<Order> orders;

    /* run before each benchmark */
    @Setup
    public void setUp(SizeState sizeState) {
        System.out.println(getClass().getSimpleName() + " > setup > populate");
        orders = repositorySupplier.get();

        IntStream.rangeClosed(1, sizeState.size)
                .mapToObj(id -> new Order(id,id,id))
                .forEach(orders::add);
    }

    /* run after each benchmark */
    @TearDown
    public void tearDown() {
        System.out.println(getClass().getSimpleName() + " > teardown > clear");
        orders.clear();
        System.gc();
    }
}
