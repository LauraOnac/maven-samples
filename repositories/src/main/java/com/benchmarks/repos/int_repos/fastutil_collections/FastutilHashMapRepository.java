package com.benchmarks.repos.int_repos.fastutil_collections;

import com.benchmarks.repos.int_repos.IntInMemoryRepository;
import it.unimi.dsi.fastutil.ints.Int2IntOpenHashMap;

/**
 * Created by Laura on 10/28/2017.
 */
public class FastutilHashMapRepository implements IntInMemoryRepository {
    private Int2IntOpenHashMap map;

    public FastutilHashMapRepository() {
        this.map = new Int2IntOpenHashMap();
    }

    @Override
    public void add(int element) {
        map.put(element, element);
    }

    @Override
    public boolean contains(int element) {
        return map.containsKey(element);
    }

    @Override
    public void remove(int element) {
        map.remove(element);
    }

    @Override
    public void clear() {
        map.clear();
    }
}
