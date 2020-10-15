package ch3;

import java.util.Stack;

public class SortStack {

    void sort(java.util.Stack<Integer> s) {
        java.util.Stack<Integer> r = new Stack<>();
        while (!s.isEmpty()) {
            // Insert each element in s in sorted order into r
            int tmp = s.pop();
            while (!r.isEmpty() && r.peek() > tmp) {
                s.push(r.pop());
            }
            r.push(tmp);
        }

        // Copy the elements from r back into s
        while (!r.isEmpty()) {
            s.push(r.pop());
        }
    }

    public static void main(String[] args) {
        SortStack sortStack = new SortStack();
        Stack<Integer> stack = new Stack<>();
        stack.push(7);
        stack.push(10);
        stack.push(5);
        stack.push(12);
        stack.push(8);
        stack.push(3);
        stack.push(1);

        sortStack.sort(stack);
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
