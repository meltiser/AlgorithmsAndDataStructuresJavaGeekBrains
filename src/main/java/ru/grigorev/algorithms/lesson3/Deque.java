package ru.grigorev.algorithms.lesson3;

/**
 * @author Dmitriy Grigorev
 */
public class Deque {
    private int[] queue;
    private int head;
    private int tail;
    private int size;
    private int items;

    public Deque(int size) {
        this.size = size;
        this.queue = new int[size];
        head = 0;
        tail = -1;
        items = 0;
    }

    public boolean isEmpty() {
        return items == 0;
    }

    public boolean isFull() {
        return items == size;
    }

    public int length() {
        return items;
    }

    public void insertRight(int i) {
        if (isFull())
            increaseQueueSize();
        if (tail == size - 1)
            tail = -1;
        queue[++tail] = i;
        items++;
    }


    public void insertLeft(int i) {
        if (isFull())
            increaseQueueSize();
        if (head == 0)
            head = size;
        queue[--head] = i;
        items++;
    }

    public int removeLeft() {
        if (isEmpty())
            throw new RuntimeException("Queue is empty");
        int temp = queue[head++];
        head %= size;
        items--;
        return temp;
    }

    public int removeRight() {
        if (isEmpty())
            throw new RuntimeException("Queue is empty");
        int temp = queue[tail--];
        if (tail == -1) tail = size - 1;
        items--;
        return temp;
    }

    public int peek() {
        if (isEmpty())
            throw new RuntimeException("Queue is empty");
        return queue[head];
    }

    public void increaseQueueSize() {
        size *= 2;
        int[] temp = new int[size];
        if (tail >= head) {
            System.arraycopy(queue, 0, temp, 0, queue.length);
        } else {
            System.arraycopy(queue, 0, temp, 0, tail - 1);
            System.arraycopy(queue, head, temp,
                    size - (queue.length - head),
                    queue.length - head - 1);
            head = size - head - 1;
        }
        queue = temp;
    }

}
