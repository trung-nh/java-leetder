package neet_code.stack;

import java.util.ArrayList;
import java.util.List;

public class _155_MinStack {
    private final List<Integer> nodes;
    private final List<Integer> min;
    private int currentMin;

    public _155_MinStack() {
        nodes = new ArrayList<>();
        min = new ArrayList<>();
        currentMin = Integer.MAX_VALUE;
    }

    public void push(int val) {
        nodes.add(val);
        this.currentMin = Math.min(currentMin, val);
        min.add(currentMin);
    }

    public void pop() {
        nodes.removeLast();
        min.removeLast();
        currentMin = nodes.isEmpty() ? Integer.MAX_VALUE : min.getLast();
    }

    public int top() {
        return nodes.getLast();
    }

    public int getMin() {
        return min.getLast();
    }
}
