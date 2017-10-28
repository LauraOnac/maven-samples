package com.benchmarks.repos.int_repos.jdk_collections;

import com.benchmarks.repos.int_repos.IntInMemoryRepository;

import java.util.Set;
import java.util.TreeSet;

/**
 * Created by Laura on 10/28/2017.
 */
public class TreeSetRepository implements IntInMemoryRepository {
    private Set<Integer> set;

    public TreeSetRepository() {
        this.set = new TreeSet<>();
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
