package ch2;

import static ch2.Utils.createTestList;
import static ch2.Utils.printList;

public class DeleteMiddleNode {

    boolean deleteNode(LinkedListNode n) {
        if (n == null || n.next == null) {
            return false;
        }
        LinkedListNode next = n.next;
        n.data = next.data;
        n.next = next.next;
        return true;
    }

    public static void main(String[] args) {
        DeleteMiddleNode deleteMiddleNode = new DeleteMiddleNode();
        LinkedListNode list = createTestList();
        LinkedListNode tmp = list;
        printList(list);
        for (int i = 0; i < 2; i++) {
            if (tmp == null) break;
            tmp = tmp.next;
        }

        System.out.println("TMP points to " + tmp.data);

        if (tmp != null) {
            System.out.println(deleteMiddleNode.deleteNode(tmp));
            printList((tmp));
        }
    }
}
