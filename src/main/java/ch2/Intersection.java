package ch2;

public class Intersection {

    class Result {
        public LinkedListNode tail;
        public int size;

        public Result(LinkedListNode tail, int size) {
            this.tail = tail;
            this.size = size;
        }
    }

    LinkedListNode findInsersection(LinkedListNode list1, LinkedListNode list2) {
        if (list1 == null || list2 == null) {
            return null;
        }

        // Get tail and sizes
        Result result1 = getTailAndSize(list1);
        Result result2 = getTailAndSize(list2);

        // Set pointers to the start of each linked list
        LinkedListNode shorter = result1.size < result2.size ? list1 : list2;
        LinkedListNode longer = result1.size < result2.size ? list2 : list1;

        // Advance the pointer for the longer linked list by difference in lengths
        longer = getKthNode(longer, Math.abs(result1.size - result2.size));

        // Move both pointers until you have a collision
        while (shorter != longer) {
            shorter = shorter.next;
            longer = longer.next;
        }

        // Return either one
        return longer;
    }

    LinkedListNode getKthNode(LinkedListNode head, int k) {
        LinkedListNode current = head;
        while (k > 0 && current != null) {
            current = current.next;
            k--;
        }
        return current;
    }

    Result getTailAndSize(LinkedListNode list) {
        if (list == null) return  null;

        int size = 1;
        LinkedListNode current = list;
        while (current.next != null) {
            size++;
            current = current.next;
        }
        return new Result(current, size);
    }

    public static void main(String[] args) {
        Intersection intersection = new Intersection();

        LinkedListNode first = new LinkedListNode(3);
        LinkedListNode second = new LinkedListNode(1);
        LinkedListNode third = new LinkedListNode(5);
        LinkedListNode fourth = new LinkedListNode(9);

        third.next = fourth;
        second.next = third;
        first.next = second;

        LinkedListNode firsth2 = new LinkedListNode(4);
        LinkedListNode second2 = new LinkedListNode(6);

        firsth2.next = second2;

        LinkedListNode fifth = new LinkedListNode(7);
        LinkedListNode sixth = new LinkedListNode(2);
        LinkedListNode seventh = new LinkedListNode(1);

        sixth.next = seventh;
        fifth.next = sixth;

        fourth.next = fifth;
        second2.next = fifth;

        LinkedListNode result = intersection.findInsersection(first, firsth2);
        Utils.printList(result);


    }
}
