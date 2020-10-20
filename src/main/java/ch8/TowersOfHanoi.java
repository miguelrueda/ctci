package ch8;

import java.util.Iterator;
import java.util.Stack;

class Tower {

    private Stack<Integer> disks;
    private int index;

    public Tower(int i) {
        disks = new Stack<>();
        index = i;
    }


    public int index() {
        return index;
    }

    public void add(int d) {
        if (!disks.isEmpty() && disks.peek() <= d) {
            System.out.println("Error placing disk " + d);
        } else {
            disks.push(d);
        }
    }

    public void moveDisks(int n, Tower destination, Tower buffer) {
        if (n > 0) {
            moveDisks(n - 1, buffer, destination);
            moveToTop(destination);
            buffer.moveDisks(n - 1, destination, this);
        }
    }

    public void moveToTop(Tower t) {
        int top = disks.pop();
        t.add(top);
    }

    public void print() {
        System.out.println("*********************");
        if (disks.isEmpty()) {
            System.out.println("The tower is empty");
        } else {
            Iterator<Integer> iterator = disks.iterator();
            while (iterator.hasNext()) {
                Integer next = iterator.next();
                System.out.println(next);
            }
        }
        System.out.println("*********************");
    }
}

public class TowersOfHanoi {

    public static void main(String[] args) {
        int n = 3;
        Tower[] towers = new Tower[n];
        for(int i = 0; i < 3; i++) {
            towers[i] = new Tower(i);
        }

        for(int i = n - 1; i >= 0; i--) {
            towers[0].add(i);
        }
        towers[0].moveDisks(n, towers[2], towers[1]);

        towers[0].print();
        towers[1].print();
        towers[2].print();
    }
}
