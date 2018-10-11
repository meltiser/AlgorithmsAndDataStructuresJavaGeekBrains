package ru.grigorev.algorithms.lesson4.webinar;

import ru.grigorev.algorithms.lesson3.examples.Stack;

public class Brackets {
    private static void error(char ch, int i) {
        System.out.printf("Error: %c at %d\n", ch, i);
    }

    public static boolean check(String input) {
        int size = input.length();
        Stack stack = new Stack(size);
        for (int i = 0; i < size; i++) {
            char ch = input.charAt(i);
            if (ch == '[' || ch == '{' || ch == '(')
                stack.insert(ch);
            else if (ch == ']' || ch == '}' || ch == ')') {
                if (stack.isEmpty()) {
                    error(ch, i);
                    return false;
                }
                char c = (char) stack.remove();
                if (!((c == '[' && ch == ']') ||
                        (c == '(' && ch == ')') ||
                        (c == '{' && ch == '}'))) {
                    error(ch, i);
                    return false;
                }
            }
        }
        if (!stack.isEmpty()) {
            error((char) stack.peek(), size - 1);
            return false;
        }
        return true;
    }

}
