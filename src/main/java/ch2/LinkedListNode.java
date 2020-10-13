package ch2;

public class LinkedListNode {

    public LinkedListNode next = null;
    public int data;

    public  LinkedListNode(int d) {
        data = d;
    }

    public void appendToTail(int data) {
        LinkedListNode newNode = new LinkedListNode(data);
        LinkedListNode n = this;
        while (n.next != null) {
            n = n.next;
        }
        n.next = newNode;
    }
}
