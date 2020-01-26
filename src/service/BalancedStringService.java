package service;

import java.util.Stack;

public interface BalancedStringService {
    static boolean balancedString(String str) {
        Stack stack = new Stack();
        String[] arrEx = str.split("");
        if (stack.isEmpty() && (arrEx[0].equals(")") ||
                                arrEx[0].equals("]") ||
                                arrEx[0].equals("}"))) {
            return false;
        }
        if (arrEx[arrEx.length-1].equals("(") ||
            arrEx[arrEx.length-1].equals("[") ||
            arrEx[arrEx.length-1].equals("{")) {
            return false;
        }
        stack.push(arrEx[0]);
        for (int i = 1; i<=arrEx.length-1; i++) {
            if (arrEx[i].equals("}")) {
                if (!stack.isEmpty() && stack.peek().equals("{")) {
                    stack.pop();
                } else {
                    return false;
                }
            } else if (arrEx[i].equals(")")) {
                if (!stack.isEmpty() && stack.peek().equals("(")) {
                    stack.pop();

                } else {
                    return false;
                }
            } else if (arrEx[i].equals("]")) {
                if (!stack.isEmpty() && stack.peek().equals("[")) {
                    stack.pop();
                } else {
                    return false;
                }
            } else {
                stack.push(arrEx[i]);
            }
        }
        return stack.isEmpty() ? true : false;
    }
}
