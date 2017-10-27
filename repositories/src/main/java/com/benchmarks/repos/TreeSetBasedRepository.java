package com.benchmarks.repos;

import java.util.Set;
import java.util.TreeSet;

/**
 * Created by Laura on 10/17/2017.
 */
public class TreeSetBasedRepository<T> implements InMemoryRepository<T> {
    private Set<T> set;

    public TreeSetBasedRepository() {
        this.set = new TreeSet<>();
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
