package ch2;

import java.util.HashSet;

import static ch2.Utils.printList;

public class RemoveDups {

    void deleteDups(LinkedListNode n) {
        HashSet<Integer> set = new HashSet<>();
        LinkedListNode previous = null;
        while (n != null) {
            if (set.contains(n.data)) {
                previous.next = n.next;
            } else {
                set.add(n.data);
                previous = n;
            }
            n = n.next;
        }
    }

    void deleteDups2(LinkedListNode head) {
        LinkedListNode current = head;
        while (current != null) {
            // Remove all future nodes that have the same value
            LinkedListNode runner = current;
            while (runner.next != null) {
                if (runner.next.data == current.data) {
                    runner.next = runner.next.next;
                } else {
                    runner = runner.next;
                }
            }
            current = current.next;
        }
    }

    public static void main(String[] args) {
        LinkedListNode list = new LinkedListNode(1);
        list.appendToTail(2);
        list.appendToTail(3);
        list.appendToTail(2);
        list.appendToTail(4);
        list.appendToTail(1);
        printList(list);

        System.out.println("After");
        RemoveDups removeDups = new RemoveDups();
        removeDups.deleteDups2(list);
        printList(list);

    }
}
