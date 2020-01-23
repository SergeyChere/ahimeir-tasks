package service;

import java.util.Stack;

public interface TakeMinElementInStackService {
    static int minElementInStack(Stack stack) {
        Stack stack2 = new Stack();
        int res = (int) stack.pop();
        while (!stack.isEmpty()) {
            if (res < (int) stack.peek()) {
                stack2.push(stack.pop());
            } else {
                stack2.push(res);
                res = (int) stack.pop();
            }
        }
        stack2.push(res);
        return (int) stack2.peek();
    }
}
