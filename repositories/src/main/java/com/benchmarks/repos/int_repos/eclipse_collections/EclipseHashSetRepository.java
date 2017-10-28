package com.benchmarks.repos.int_repos.eclipse_collections;

import com.benchmarks.repos.int_repos.IntInMemoryRepository;
import org.eclipse.collections.impl.set.mutable.primitive.IntHashSet;


/**
 * Created by Laura on 10/28/2017.
 */
public class EclipseHashSetRepository implements IntInMemoryRepository {
    private IntHashSet set;

    public EclipseHashSetRepository() {
        this.set = new IntHashSet();
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
