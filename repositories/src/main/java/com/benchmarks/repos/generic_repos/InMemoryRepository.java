package com.benchmarks.repos.generic_repos;

/**
 * Created by Laura on 10/17/2017.
 */
public interface InMemoryRepository<T> {
    void add(T element);
    boolean contains(T element);
    void remove(T element);
    void clear();
}
