package com.benchmarks.repos.int_repos.fastutil_collections;

import com.benchmarks.repos.int_repos.IntInMemoryRepository;
import it.unimi.dsi.fastutil.ints.IntOpenHashSet;

/**
 * Created by Laura on 10/28/2017.
 */
public class FastutilHashSetRepository implements IntInMemoryRepository {
    private IntOpenHashSet set;

    public FastutilHashSetRepository() {
        this.set = new IntOpenHashSet();
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
