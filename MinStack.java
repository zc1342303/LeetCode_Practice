package leetcode;

import java.util.*;

public class MinStack {
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();
    public MinStack() {
    }

    public void push(int x) {
        stack.push(x);
        if (minStack.empty() || x <= minStack.peek())
            minStack.push(x);
    }

    public void pop() {
        int del = stack.pop();
        if (del == minStack.peek())
            minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
