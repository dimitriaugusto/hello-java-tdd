package com.dimiaug.hello.tdd.stack;

public class Stack {

    private int size = 0;
    private final int[] elements = new int[2];

    public boolean isEmpty() {
        return size == 0;
    }

    public void push(int element) {
        this.elements[size++] = element;
    }

    public int pop() {
        if (size == 0) throw new Underflow();
        return elements[--size];
    }

    public int getSize() {
        return size;
    }

    public static class Underflow extends RuntimeException {
    }

}
