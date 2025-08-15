package com.mateusnavarro77.estruturas.bag;

import java.util.Iterator;
import java.util.LinkedList;

public interface Bag<T> extends Iterable<T> {
    public boolean isEmpty();

    public int size();

    public void add(T item);
}