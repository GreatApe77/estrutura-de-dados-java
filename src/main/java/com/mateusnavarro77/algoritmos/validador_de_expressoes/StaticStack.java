package com.mateusnavarro77.algoritmos.validador_de_expressoes;

interface Stack<T> {
    boolean isEmpty();

    boolean isFull();

    void push(T element);

    T pop();

    T top();

    int size();

}

public class StaticStack<T> implements Stack<T> {
    private T[] elements;
    private int size;

    @SuppressWarnings("unchecked")
    public StaticStack(int maxCapacity) {
        this.elements = (T[]) new Object[maxCapacity];
        this.size = 0;
    }

    public StaticStack() {
        this(10);
    }

    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }

    @Override
    public boolean isFull() {
        return this.size() == this.elements.length;
    }

    @Override
    public void push(T element) {
        if (isFull())
            throw new StackOverflowError();

        this.elements[size()] = element;
        this.size++;
    }

    @Override
    public T pop() {
        if (isEmpty())
            throw new Error("Empty stack");
        T topElement = top();
        this.size--;
        return topElement;
    }

    @Override
    public T top() {

        return this.elements[size() - 1];
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("[");

        for (int i = 0; i < size(); i++) {
            if (i == size() - 1) {
                s.append(this.elements[i]);
            } else {
                s.append(this.elements[i]);
                s.append(", ");
            }
        }
        s.append("]");
        return s.toString();
    }
}