package ch2;

public class Utils {

    public static void printList(LinkedListNode node) {
        while (node != null) {
            System.out.print(node.data + " --> ");
            node = node.next;
        }
        System.out.print("NULL");
        System.out.println("");
    }

    public static LinkedListNode createTestList() {
        LinkedListNode list = new LinkedListNode(1);
        list.appendToTail(2);
        list.appendToTail(3);
        list.appendToTail(2);
        list.appendToTail(4);
        list.appendToTail(1);

        return list;
    }

    public static LinkedListNode createStraightList(int size) {
        if (size <= 0) {
            return new LinkedListNode(1);
        }
        LinkedListNode list = new LinkedListNode(0);
        for (int i = 1; i < size; i++) {
            list.appendToTail(i);
        }
        return list;
    }

    public static LinkedListNode createCustomTestList(int [] array) {
        if (array.length <= 0) {
            return new LinkedListNode(0);
        }
        LinkedListNode list = new LinkedListNode(array[0]);
        for (int i = 1; i < array.length; i++) {
            list.appendToTail(array[i]);
        }
        return list;
    }

    public static int length(LinkedListNode head) {
        if (head == null) return 0;
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        return count;
    }

}
