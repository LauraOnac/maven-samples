package com.benchmarks.repos;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Laura on 10/17/2017.
 */
public class ArrayListBasedRepository<T> implements InMemoryRepository<T> {
    private List<T> list;

    public ArrayListBasedRepository() {
        this.list = new ArrayList<>();
    }

    @Override
    public void add(T element) {
        list.add(element);
    }

    @Override
    public boolean contains(T element) {
        return list.contains(element);
    }

    @Override
    public void remove(T element) {
        list.remove(element);
    }

    @Override
    public void clear(){
        list.clear();
    }
}
