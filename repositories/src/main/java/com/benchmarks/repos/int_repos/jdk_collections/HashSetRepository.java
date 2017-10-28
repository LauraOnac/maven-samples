package com.benchmarks.repos.int_repos.jdk_collections;

import com.benchmarks.repos.int_repos.IntInMemoryRepository;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Laura on 10/28/2017.
 */
public class HashSetRepository implements IntInMemoryRepository{
    private Set<Integer> set;

    public HashSetRepository() {
        this.set = new HashSet<>();
    }

    @Override
    public void add(int element) {
        set.add(element);
    }

    @Override
    public boolean contains(int element) {
        return set.contains(element);
    }

    @Override
    public void remove(int element) {
        set.remove(element);
    }

    @Override
    public void clear() {
        set.clear();
    }
}
