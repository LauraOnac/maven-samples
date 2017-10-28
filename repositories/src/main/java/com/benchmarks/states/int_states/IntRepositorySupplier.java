package com.benchmarks.states.int_states;

import com.benchmarks.repos.int_repos.IntInMemoryRepository;
import com.benchmarks.repos.int_repos.eclipse_collections.EclipseArrayListRepository;
import com.benchmarks.repos.int_repos.eclipse_collections.EclipseHashSetRepository;
import com.benchmarks.repos.int_repos.jdk_collections.ArrayListRepository;
import com.benchmarks.repos.int_repos.jdk_collections.ConcurrentHashMapRepository;
import com.benchmarks.repos.int_repos.jdk_collections.HashSetRepository;
import com.benchmarks.repos.int_repos.jdk_collections.TreeSetRepository;

import java.util.function.Supplier;

/**
 * Created by Laura on 10/27/2017.
 */
public enum IntRepositorySupplier implements Supplier<IntInMemoryRepository> {
    ARRAY_LIST() {
        @Override
        public IntInMemoryRepository get() {
            return new ArrayListRepository();
        }
    },

    HASH_SET() {
        @Override
        public IntInMemoryRepository get() {
            return new HashSetRepository();
        }
    },

//    TREE_SET() {
//        @Override
//        public IntInMemoryRepository get() {
//            return new TreeSetRepository();
//        }
//    },
//    CONCURRENT_HASH_MAP() {
//        @Override
//        public IntInMemoryRepository get() {
//            return new ConcurrentHashMapRepository();
//        }
//    },

    ECLIPSE_ARRAY_LIST(){
        @Override
        public IntInMemoryRepository get() {
            return new EclipseArrayListRepository();
        }
    },

    ECLIPSE_HASH_SET(){
        @Override
        public IntInMemoryRepository get() {
            return new EclipseHashSetRepository();
        }
    }
}
