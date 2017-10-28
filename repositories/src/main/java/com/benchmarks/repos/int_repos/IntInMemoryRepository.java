package com.benchmarks.repos.int_repos;

/**
 * Created by Laura on 10/27/2017.
 */
public interface IntInMemoryRepository {
    void add(int element);
    boolean contains(int element);
    void remove(int element);
    void clear();
}
