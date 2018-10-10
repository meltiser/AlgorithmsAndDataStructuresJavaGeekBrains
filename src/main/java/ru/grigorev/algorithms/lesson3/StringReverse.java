package ru.grigorev.algorithms.lesson3;

import ru.grigorev.algorithms.lesson3.examples.Stack;

/**
 * @author Dmitriy Grigorev
 */
public class StringReverse {
    public static String reverseSB(String s) {
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        return sb.toString();
    }

    public static String reverseStack(String s) {
        char[] temp = s.toCharArray();
        Stack stack = new Stack(s.length());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < temp.length; i++) {
            stack.insert(temp[i]);
        }
        while (!stack.isEmpty()) {
            sb.append((char) stack.remove());
        }
        return sb.toString();
    }
}
