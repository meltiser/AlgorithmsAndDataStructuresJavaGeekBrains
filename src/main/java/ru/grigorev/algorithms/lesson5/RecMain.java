package ru.grigorev.algorithms.lesson5;

/**
 * @author Dmitriy Grigorev
 */
public class RecMain {
    private static int steps;

    public static void main(String[] args) {
        System.out.println(powerRec(2, 10));
        System.out.println(hanoiTowers(9));
    }

    public static int powerRec(int base, int sign) {
        if (sign == 0) return 1;
        if (sign % 2 != 0) return powerRec(base, sign - 1) * base;
        else return powerRec(base * base, sign / 2);
    }

    public static int hanoiTowers(int rings) {
        moveRings(rings,"A", "B", "C");
        return steps;
    }

    public static void move(String tower1, String tower2) {
        //System.out.println("Moving ring from " + tower1 + " to " + tower2);
        steps++;
    }

    public static void moveRings(int rings, String tower1, String tower2, String towerTemp) {
        if (rings == 0) return;

        moveRings(rings - 1, tower1 , towerTemp, tower2);
        move(tower1, tower2);
        moveRings(rings - 1, towerTemp , tower2, tower1);
    }
}
