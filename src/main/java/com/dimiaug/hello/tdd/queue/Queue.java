package com.dimiaug.hello.tdd.queue;

public class Queue {

    private final int[] elements = new int[2];
    private int size = 0;
    private int firstIn = 0;
    private int lastIn = -1;

    public boolean isEmpty() {
        return size == 0;
    }

    public void push(int element) {
        if (size == elements.length) throw new QueueOverflow();

        lastIn = nextCircularValue(lastIn);
        this.elements[lastIn] = element;
        ++size;
    }

    public int pop() {
        if (size == 0) throw new QueueUnderflow();

        int pop = elements[firstIn];
        firstIn = nextCircularValue(firstIn);
        --size;
        return pop;
    }

    int nextCircularValue(int pointer) {
        return ++pointer % elements.length;
    }

    public int size() {
        return size;
    }

    public static class QueueUnderflow extends RuntimeException {
    }

    public static class QueueOverflow extends RuntimeException {
    }
}
