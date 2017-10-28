package com.benchmarks.states.order_states;

import com.benchmarks.repos.generic_repos.*;

import java.util.function.Supplier;

/**
 * Created by Laura on 10/26/2017.
 */
public enum RepositorySupplier implements Supplier<InMemoryRepository<Order>> {
//    HASH_SET() {
//        @Override
//        public InMemoryRepository<Order> get() {
//            return new HashSetBasedRepository<>();
//        }
//    },
//
//    TREE_SET() {
//        @Override
//        public InMemoryRepository<Order> get() {
//            return new TreeSetBasedRepository<>();
//        }
//    },
//
//    ARRAY_LIST() {
//        @Override
//        public InMemoryRepository<Order> get() {
//            return new ArrayListBasedRepository<>();
//        }
//    },

    CONCURRENT_HASH_MAP() {
        @Override
        public InMemoryRepository<Order> get() {
            return new ConcurrentHashMapBasedRepository<>();
        }
    }
}