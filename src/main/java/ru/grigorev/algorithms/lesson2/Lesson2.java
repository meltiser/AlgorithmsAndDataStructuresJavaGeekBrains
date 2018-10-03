package ru.grigorev.algorithms.lesson2;

/**
 * @author Dmitriy Grigorev
 * **** Дописать методы удаления в классе массива
 * **** Улучшить пузырьковую сортировку
 * **** Подсчитать количество операций в сортировках и сравнить с их О-большое
 * **** * Реализовать сортировку подсчётом
 */
public class Lesson2 {
    public static void main(String[] args) {
        Array arrayOne = new Array();
        Array arrayTwo = new Array();
        arrayOne.fillRandomValues(10000);
        arrayTwo.fillRandomValues(10000);

        long time1 = System.currentTimeMillis();
        arrayOne.sortBubble();
        long time2 = System.currentTimeMillis();
        arrayTwo.sortBubbleImproved();
        long time3 = System.currentTimeMillis();

        System.out.println("bubble sort: " + (time2 - time1) + " ms");
        System.out.println("improved bubble sort: " + (time3 - time2) + " ms"); // ~ 200 ms faster with 10000 values

        Array arr = new Array(1, 2, 3, 4, 2, 1, 2, 7);
        System.out.println("before count sort: " + arr);
        arr.sortCount();
        System.out.println("after count sort: " + arr);
    }
}
