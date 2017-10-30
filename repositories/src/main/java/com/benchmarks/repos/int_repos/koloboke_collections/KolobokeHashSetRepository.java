package com.benchmarks.repos.int_repos.koloboke_collections;

import com.benchmarks.repos.int_repos.IntInMemoryRepository;
import com.koloboke.collect.set.hash.HashIntSet;
import com.koloboke.collect.set.hash.HashIntSets;


/**
 * Created by Laura on 10/30/2017.
 */
public class KolobokeHashSetRepository implements IntInMemoryRepository {
    private HashIntSet set;

    public KolobokeHashSetRepository() {
        this.set = HashIntSets.getDefaultFactory().newMutableSet();
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
        set.removeInt(element);
    }

    @Override
    public void clear() {
        set.clear();
    }
}
