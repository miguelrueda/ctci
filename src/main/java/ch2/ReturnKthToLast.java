package ch2;

import static ch2.Utils.printList;

public class ReturnKthToLast {

    int printKthToLast(LinkedListNode head, int k) {
        if (head == null) {
            return 0;
        }
        int index = printKthToLast(head.next, k) + 1;
        if (index == k) {
            System.out.println(k + "th to last node is " + head.data);
        }
        return index;
    }

    // Approach C: Create a wrapper class
    class Index {
        public int value = 0;
    }

    LinkedListNode kthToLast(LinkedListNode head, int k) {
        Index index = new Index();
        return kthToLast(head, k, index);
    }

    LinkedListNode kthToLast(LinkedListNode head, int k, Index index) {
        if (head == null) {
            return null;
        }
        LinkedListNode node = kthToLast(head.next, k, index);
        index.value = index.value + 1;
        if (index.value == k) {
            return head;
        }
        return node;
    }

    // Solution #3 Iterative
    LinkedListNode nthToLast(LinkedListNode head, int k) {
        LinkedListNode p1 = head;
        LinkedListNode p2 = head;

        // Move p1 k nodes into the list
        for (int i = 0; i < k; i++) {
            if (p1 == null) return null;
            p1 = p1.next;
        }

        System.out.println("P1 is at " + p1.data);

        // Move them at the same pace. When p1 hits the end, p2 will be at the right element
        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }

        return p2;
    }

    public static void main(String[] args) {
        LinkedListNode list = new LinkedListNode(1);
        list.appendToTail(2);
        list.appendToTail(3);
        list.appendToTail(2);
        list.appendToTail(4);
        list.appendToTail(1);
        printList(list);

        ReturnKthToLast returnKthToLast = new ReturnKthToLast();
//        System.out.println(returnKthToLast.kthToLast(list, 2).data);
        System.out.println(returnKthToLast.nthToLast(list, 2).data);
    }
}
