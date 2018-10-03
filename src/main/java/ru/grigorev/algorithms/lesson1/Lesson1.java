package ru.grigorev.algorithms.lesson1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Dmitriy Grigorev
 * <p>
 * ### 1. Описать простейшие алгоритмы
 * #### 1.1. Возведение в степень используя чётность степени
 * #### 1.2. Поиск минимального элемента в массиве
 * #### 1.3. Нахождение среднего арифметического массива
 * ### 2. Подсчитать сложность описанных алгоритмов
 * ### 3. Какие правила подсчёта применялись, оставьте комментарии в коде
 */
public class Lesson1 {
    private static int[] array = {3, 7, 8, 1, 6, 9};

    public static void main(String[] args) {
        System.out.println(exponentiation(7, 9));
        System.out.println(minValue(array));
        System.out.println(average(array));
    }

    public static int exponentiation(int base, int power) { // O(log n * n)
        int newPower = power;
        int newBase = base;
        List<Integer> values = new ArrayList<>();
        while (newPower != 2) { // O(log n)
            if (newPower % 2 == 0) {
                newPower = newPower / 2;
                newBase *= newBase;
            } else {
                newPower = newPower - 1;
                values.add(newBase);
            }
        }
        newBase *= newBase;
        for (int i = 0; i < values.size(); i++) { // O (n)
            newBase *= values.get(i);
        }
        return newBase; // O(log n) * O(n) = O(log n * n)
    }

    public static int minValue(int[] array) { // O(n)
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (min > array[i]) min = array[i];
        }
        return min;
    }

    public static double average(int[] array) { // O(n)
        double sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        return sum / array.length;
    }
}
