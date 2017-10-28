package com.benchmarks.repos.generic_repos;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Laura on 10/17/2017.
 */
public class HashSetBasedRepository<T> implements InMemoryRepository<T> {
    private Set<T> set;

    public HashSetBasedRepository() {
        this.set = new HashSet<>();
    }

    @Override
    public void add(T element) {
        set.add(element);
    }

    @Override
    public boolean contains(T element) {
        return set.contains(element);
    }

    @Override
    public void remove(T element) {
        set.remove(element);
    }

    @Override
    public void clear() {
        set.clear();
    }
}
