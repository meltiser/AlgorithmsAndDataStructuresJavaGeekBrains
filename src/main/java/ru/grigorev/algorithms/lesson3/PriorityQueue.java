package ru.grigorev.algorithms.lesson3;

import java.util.Arrays;

/**
 * @author Dmitriy Grigorev
 */
public class PriorityQueue {
    private int[] queue;
    private int head;
    private int tail;
    private int size;
    private int items;

    public PriorityQueue(int size) {
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

    public void insert(int i) {
        if (isFull())
            increaseQueueSize();
        int index;
        if (isEmpty()) {
            if (tail == size - 1)
                tail = -1;
            queue[++tail] = i;
            items++;
        } else {
            for (index = items - 1; index >= 0; index--) {
                if (i > queue[index])
                    queue[index + 1] = queue[index];
                else
                    break;
            }
            queue[index + 1] = i; // Вставка элемента
            items++;
        }
    }

    public int remove() {
        if (isEmpty())
            throw new RuntimeException("Queue is empty");
        int temp = queue[head++];
        head %= size;
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

    public void printState() {
        System.out.println("--------------------------------------");
        System.out.println("array :" + Arrays.toString(queue));
        System.out.println("head: " + head);
        System.out.println("tail: " + tail);
        System.out.println("size: " + tail);
        System.out.println("items: " + tail);
        System.out.println("--------------------------------------");
    }
}
