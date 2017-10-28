package com.benchmarks.repos.int_repos.eclipse_collections;

import com.benchmarks.repos.int_repos.IntInMemoryRepository;
import org.eclipse.collections.impl.map.mutable.primitive.IntIntHashMap;

/**
 * Created by Laura on 10/28/2017.
 */
public class EclipseHashMapRepository implements IntInMemoryRepository {
    private IntIntHashMap map;

    public EclipseHashMapRepository() {
        this.map = new IntIntHashMap();
    }

    @Override
    public void add(int element) {
        map.put(element, element);
    }

    @Override
    public boolean contains(int element) {
        return map.containsValue(element);
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
