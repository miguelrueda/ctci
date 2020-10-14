package ch2;

public class Partition {

    LinkedListNode partition(LinkedListNode node, int x) {
        LinkedListNode beforeStart = null;
        LinkedListNode beforeEnd = null;
        LinkedListNode afterStart = null;
        LinkedListNode afterEnd = null;

        // Partition list
        while (node != null) {
            LinkedListNode next = node.next;
            node.next = null;
            System.out.println("Analyzing node " + node.data);
            if (node.data < x) {
                // Insert node into end of before list
                if (beforeStart ==  null) {
                    beforeStart = node;
                    beforeEnd = beforeStart;
                } else {
                    beforeEnd.next = node;
                    beforeEnd = node;
                }
            } else {
                // Insert node into end of after list
                if (afterStart == null) {
                    afterStart = node;
                    afterEnd = afterStart;
                } else {
                    afterEnd.next = node;
                    afterEnd = node;
                }
            }
            node = next;
        }

        if (beforeStart == null) {
            return afterStart;
        }

        // Merge before list and after list
        beforeEnd.next = afterStart;
        return beforeStart;
    }

    LinkedListNode partition2(LinkedListNode node, int x) {
        LinkedListNode head = node;
        System.out.println("HEAD ");
        Utils.printList(head);
        LinkedListNode tail = node;
        System.out.println("TAIL");
        Utils.printList(tail);

        while (node != null) {
            LinkedListNode next = node.next;
            if (node.data < x) {
                // Insert node at head
                node.next = head;
                head = node;
            } else {
                // Insert node at tail
                tail.next = node;
                tail = node;
            }

            node = next;
        }
        tail.next = null;

        Utils.printList(head);
        // The head has changed so we need to return it to the user
        return head;

    }

    public static void main(String[] args) {
        LinkedListNode list = new LinkedListNode(3);
        list.appendToTail(5);
        list.appendToTail(8);
        list.appendToTail(5);
        list.appendToTail(10);
        list.appendToTail(2);
        list.appendToTail(1);

        Utils.printList(list);

        Partition partition = new Partition();
        Utils.printList(partition.partition2(list, 5));


    }

}
