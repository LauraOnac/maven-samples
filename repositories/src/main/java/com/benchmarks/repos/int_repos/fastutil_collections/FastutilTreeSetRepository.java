package com.benchmarks.repos.int_repos.fastutil_collections;

import com.benchmarks.repos.int_repos.IntInMemoryRepository;
import it.unimi.dsi.fastutil.ints.IntAVLTreeSet;

/**
 * Created by Laura on 10/28/2017.
 */
public class FastutilTreeSetRepository implements IntInMemoryRepository {
    private IntAVLTreeSet set;

    public FastutilTreeSetRepository() {
        this.set = new IntAVLTreeSet();
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
