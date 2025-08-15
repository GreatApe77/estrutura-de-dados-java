package com.mateusnavarro77.estruturas.bag;

import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListBag<T> implements Bag<T> {
    private LinkedList<T> list = new LinkedList<T>();

    @Override
    public Iterator<T> iterator() {
        return list.iterator();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public void add(T item) {
        list.add(item);
    }

}
