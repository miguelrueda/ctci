/**
 * REFERENCE https://www.geeksforgeeks.org/implementing-a-linked-list-in-java-using-class/
 */
package linkedlist;

public class CustomLinkedList {

    Node head;

    static class Node {

        Node next = null;
        int data;

        public Node(int d) {
            data = d;
        }
    }


    public static CustomLinkedList insert(CustomLinkedList list, int data) {
        Node new_node = new Node(data);
        new_node.next = null;

        if (list.head == null) {
            list.head = new_node;
        } else {
            // Traverse till the last node
            Node last = list.head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = new_node;
        }
        return list;
    }

//    Node deleteNode(Node head, int d) {
//        Node n = head;
//
//        if (n.data == d) {
//            return head.next;
//        }
//
//        while (n.next != null) {
//            if (n.next.data == d) {
//                n.next = n.next.next;
//                return head;
//            }
//            n = n.next;
//        }
//        return head;
//    }

    public static void printList(CustomLinkedList list) {
        Node current = list.head;
        while (current != null) {
            System.out.print(current.data + " --> ");
            current = current.next;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {
        CustomLinkedList customLinkedList = new CustomLinkedList();
        insert(customLinkedList, 1);
        insert(customLinkedList, 2);
        insert(customLinkedList, 3);

        printList(customLinkedList);
    }
}
