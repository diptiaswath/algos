package com.daswath.examples.linkedlists;

/**
 * PROBLEM : Implement queue with a fixed size array
 * add to tail of queue and remove from front of queue
 */
public class QueueAsArray<T> {
    private T[] a;
    private int size;
    private int first = 0;
    private int last = 0;

    public QueueAsArray(int size) {
        this.size = size;
        a = (T[]) new Object[size];
    }


    public void enqueue(T element) {
        if (isFull()) {
           return;
        }
        a[last++] = element;
    }

    public T dequeue() {
        if (isEmpty()) {
            return null;
        }

        T e = a[first];
        a[first] = null;
        first += 1;
        return e;
    }

    public boolean isFull() {
        if (last >= size) {
            if (first > 0) {
                last = first - 1;
                return false;
            }
            return true;
        }
        if (first > 0 && last == first) {
            return true;
        }
        return false;
    }

    public boolean isEmpty() {
        if (a[first] == null) {
            return true;
        }
        return false;
    }

    public void print() {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " -> ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        QueueAsArray<Integer> q = new QueueAsArray<Integer>(4);
        q.enqueue(3);
        q.enqueue(18);
        q.enqueue(15);
        q.enqueue(2);
        q.enqueue(4);

        q.print();

        System.out.println(q.dequeue());

        q.print();
        q.enqueue(5);
        q.print();
        q.enqueue(6);
        q.print();

        System.out.println(q.dequeue());
        q.print();

        q.enqueue(100);
        q.print();
        System.out.println(q.dequeue());

        q.enqueue(200);
        q.print();

    }
}
