package com.benchmarks.repos.int_repos.jdk_collections;

import com.benchmarks.repos.int_repos.IntInMemoryRepository;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Laura on 10/28/2017.
 */
public class ConcurrentHashMapRepository implements IntInMemoryRepository{
    private Map<Integer,Integer> map;

    public ConcurrentHashMapRepository() {
        this.map = new ConcurrentHashMap<>();
    }

    @Override
    public void add(int element) {
        map.put(Objects.hash(element), element);
    }

    @Override
    public boolean contains(int element) {
        return map.containsValue(element);
    }

    @Override
    public void remove(int element) {
        map.values().remove(element);
    }

    @Override
    public void clear() {
        map.clear();
    }
}
