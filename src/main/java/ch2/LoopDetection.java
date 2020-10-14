package ch2;

public class LoopDetection {

    LinkedListNode findBeginning(LinkedListNode head) {
        LinkedListNode slow = head;
        LinkedListNode fast = head;

        // Find meeting point, this will be LOOP_SIZE - k steps into the linked list
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) { // collition
                break;
            }
        }

        // Error check no meeting point and therefore no loop
        if (fast == null || fast.next == null) {
            return null;
        }

        // Move slow to head. Keep fast and meeting point. Each are k steps from the loop start.
        // If they move at the same pace, the must meet at loop start
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return fast;
    }

    public static void main(String[] args) {
        LinkedListNode node1 = new LinkedListNode(1);
        LinkedListNode node2 = new LinkedListNode(2);
        LinkedListNode node3 = new LinkedListNode(3);
        LinkedListNode node4 = new LinkedListNode(4);
        LinkedListNode node5 = new LinkedListNode(5);
        LinkedListNode node6 = new LinkedListNode(6);
        LinkedListNode node7 = new LinkedListNode(7);
        LinkedListNode node8 = new LinkedListNode(8);
        LinkedListNode node9 = new LinkedListNode(9);
        LinkedListNode node10 = new LinkedListNode(10);
        LinkedListNode node11 = new LinkedListNode(11);

        node10.next = node11;
        node9.next = node10;
        node8.next = node9;
        node7.next = node8;
        node6.next = node7;
        node5.next = node6;
        node4.next = node5;
        node3.next = node4;
        node2.next = node3;
        node1.next = node2;

        node11.next = node4;

//        Utils.printList(node1);

        LoopDetection loopDetection = new LoopDetection();
        LinkedListNode beginning = loopDetection.findBeginning(node1);
        if (beginning != null) {
            System.out.println(beginning.data);
        }

    }
}
