package ch3;

import java.util.Stack;

class NodeWithMin {
    public int value;
    public int min;

    public NodeWithMin(int v, int min) {
        value = v;
        this.min = min;
    }
}

public class StackMin extends Stack<NodeWithMin> {

    public void push(int value) {
        int newMin = Math.min(value, min());
        super.push(new NodeWithMin(value, newMin));
    }

    public int min() {
        if (this.isEmpty()) {
            return Integer.MAX_VALUE;
        } else {
            return peek().min;
        }
    }

}
