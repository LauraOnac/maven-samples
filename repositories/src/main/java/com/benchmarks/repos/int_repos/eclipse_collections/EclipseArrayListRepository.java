package com.benchmarks.repos.int_repos.eclipse_collections;

import com.benchmarks.repos.int_repos.IntInMemoryRepository;
import org.eclipse.collections.impl.list.mutable.primitive.IntArrayList;

/**
 * Created by Laura on 10/27/2017.
 */
public class EclipseArrayListRepository implements IntInMemoryRepository {
    private IntArrayList list;

    public EclipseArrayListRepository() {
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
