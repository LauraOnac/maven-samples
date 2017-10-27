package com.benchmarks.states;

import com.benchmarks.Order;
import com.benchmarks.repos.ArrayListBasedRepository;
import com.benchmarks.repos.HashSetBasedRepository;
import com.benchmarks.repos.InMemoryRepository;
import com.benchmarks.repos.TreeSetBasedRepository;

import java.util.function.Supplier;

/**
 * Created by Laura on 10/26/2017.
 */
public enum RepositorySupplier implements Supplier<InMemoryRepository<Order>> {
    HASH_SET() {
        @Override
        public InMemoryRepository<Order> get() {
            return new HashSetBasedRepository<>();
        }
    },


    TREE_SET() {
        @Override
        public InMemoryRepository<Order> get() {
            return new TreeSetBasedRepository<>();
        }
    },

    ARRAY_LIST() {
        @Override
        public InMemoryRepository<Order> get() {
            return new ArrayListBasedRepository<>();
        }
    },

    CONCURRENT_HASH_MAP() {
        @Override
        public InMemoryRepository<Order> get() {
            return new HashSetBasedRepository<>();
        }
    }

}