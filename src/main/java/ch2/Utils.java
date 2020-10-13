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

}
