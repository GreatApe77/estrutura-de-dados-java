package com.mateusnavarro77.estruturas.bag;

public interface Bag<T> extends Iterable<T> {
    public boolean isEmpty();

    public int size();

    public void add(T item);
}