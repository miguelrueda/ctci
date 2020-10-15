package ch3;

import java.util.Stack;

public class MyQueue<T> {

    Stack<T> stackNewest, stackOldest;

    public MyQueue() {
        stackNewest = new Stack<>();
        stackOldest = new Stack<>();
    }

    public int size() {
        return stackNewest.size() + stackOldest.size();
    }

    public void add(T value) {
        // Push onto stackNewest, which always has the newest elements on top
        stackNewest.push(value);
    }

    // Move elements from stackNewest into stackOldest. This is usually done so that we can do operations
    // on stackOldest
    private void shiftStacks() {
        if (stackOldest.isEmpty()) {
            while (!stackNewest.isEmpty()) {
                stackOldest.push(stackNewest.pop());
            }
        }
    }

    public T peek() {
        shiftStacks(); // Ensure stack oldest has the current elements
        return stackOldest.peek();
    }

    public T remove() {
        shiftStacks(); // Ensure stackOldest has the current elements
        return stackOldest.pop(); // pop the oldest item
    }


    public static void main(String[] args) {
        MyQueue<Integer> myQueue = new MyQueue<>();

        myQueue.add(1);
        myQueue.add(2);
        myQueue.add(3);
        myQueue.add(4);
        myQueue.add(5);

        System.out.println(myQueue.peek());
        System.out.println(myQueue.remove());
        System.out.println(myQueue.remove());
        System.out.println(myQueue.peek());



    }

}
