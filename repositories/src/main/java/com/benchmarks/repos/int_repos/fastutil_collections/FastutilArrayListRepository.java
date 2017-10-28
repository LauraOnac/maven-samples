package com.benchmarks.repos.int_repos.fastutil_collections;

import com.benchmarks.repos.int_repos.IntInMemoryRepository;
import it.unimi.dsi.fastutil.ints.IntArrayList;

/**
 * Created by Laura on 10/28/2017.
 */
public class FastutilArrayListRepository implements IntInMemoryRepository {
    private IntArrayList list;

    public FastutilArrayListRepository() {
        list = new IntArrayList();
    }

    @Override
    public void add(int element) {
        list.add(element);
    }

    @Override
    public boolean contains(int element) {
        return list.contains(element);
    }

    @Override
    public void remove(int element) {
        list.remove(element);
    }

    @Override
    public void clear() {
        list.clear();
    }
}
