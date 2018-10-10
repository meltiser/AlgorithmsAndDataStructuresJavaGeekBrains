package ru.grigorev.algorithms.lesson3;

/**
 * @author Dmitriy Grigorev
 * 1. Реализовать приоритетную очередь
 * 2. Создать программу, которая переворачивает вводимые строки (Читает справа налево).
 * 3. Создать класс для реализации дека.
 */
public class Lesson3 {
    public static void main(String[] args) {
        PriorityQueue queue = new PriorityQueue(4);
        queue.insert(4);
        queue.insert(5);
        queue.insert(7);
        queue.printState();
        queue.insert(6);
        while (!queue.isEmpty()) {
            System.out.print(queue.remove() + " ");
        }
    }
}
