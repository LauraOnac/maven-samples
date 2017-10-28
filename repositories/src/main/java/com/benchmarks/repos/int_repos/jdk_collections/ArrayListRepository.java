package com.benchmarks.repos.int_repos.jdk_collections;

import com.benchmarks.repos.int_repos.IntInMemoryRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Laura on 10/28/2017.
 */
public class ArrayListRepository implements IntInMemoryRepository {
    private List<Integer> list;

    public ArrayListRepository() {
        this.list = new ArrayList<>();
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
        list.remove(new Integer(element));
    }

    @Override
    public void clear(){
        list.clear();
    }
}
