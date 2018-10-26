package ru.grigorev.algorithms.lesson6;

import java.util.Random;

/**
 * @author Dmitriy Grigorev
 */
public class Main {
    public static final int NUMS_IN_TREE = 5;
    public static final int NUM_OF_TREES = 20;

    public static void main(String[] args) {
        Tree treeArray[] = generateTrees(NUM_OF_TREES);
        showTrees(treeArray);
        showPercentOfDisbalanced(treeArray);
    }

    public static Tree[] generateTrees(int num) {
        Random rnd = new Random();
        Tree treeArray[] = new Tree[num];
        for (int i = 0; i < treeArray.length; i++) {
            treeArray[i] = new Tree();
            for (int j = 0; j < NUMS_IN_TREE; j++) {
                treeArray[i].insert(rnd.nextInt(101)); // between 0 and 100
            }
        }
        return treeArray;
    }

    public static void showPercentOfDisbalanced(Tree[] treeArray) {
        int balanced = 0;
        for (int i = 0; i < treeArray.length; i++) {
            if (treeArray[i].isBalanced()) balanced++;
        }
        double percent = ((treeArray.length - balanced) * 100.00) / treeArray.length;
        System.out.println("disbalanced trees " + percent + "%");
    }

    public static void showTrees(Tree[] treeArray) {
        for (int i = 0; i < treeArray.length; i++) {
            treeArray[i].displayTree();
            System.out.println("is balanced: " + treeArray[i].isBalanced());
        }
    }
}
