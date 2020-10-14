package ch2;

import static ch2.Utils.length;

public class SumLists {

    LinkedListNode addLists(LinkedListNode l1, LinkedListNode l2, int carry) {
        if (l1 == null && l2 == null && carry == 0) {
            return null;
        }

        LinkedListNode result = new LinkedListNode();
        int value = carry;
        if (l1 != null) {
            value += l1.data;
        }

        if (l2 != null) {
            value += l2.data;
        }
        System.out.println("The value here is "+ value);
        // Second digit of number
        result.data = value % 10;

        // Recurse
        if (l1 != null || l2 != null) {
            LinkedListNode more = addLists(l1 == null ? null : l1.next,
                    l2 == null ? null : l2.next,
                    value >= 10 ? 1 : 0);
            result.next = more;
        }
        return result;
    }

    class PartialSum {
        public LinkedListNode sum = null;
        public int carry = 0;
    }

    LinkedListNode addLists(LinkedListNode l1, LinkedListNode l2) {
        int len1 = length(l1);
        System.out.println("Length 1 " + len1);
        int len2 = length(l2);
        System.out.println("Length 2 " + len2);

        // Pad the sorter list with zeros
        if (len1 < len2) {
            l1 = padList(l1, len2 - len1);
        } else {
            l2 = padList(l2, len1 - len2);
        }

        // Add Lists
        PartialSum sum = addListsHelper(l1, l2);

        // If there was a carry value left over, insert this at the front of the list.
        // Otherwise, just return the linked list
        if (sum.carry == 0) {
            return sum.sum;
        } else {
            LinkedListNode result = insertBefore(sum.sum, sum.carry);
            return result;
        }
    }

    PartialSum addListsHelper(LinkedListNode l1, LinkedListNode l2) {
        if (l1 == null && l2 == null) {
            PartialSum sum = new PartialSum();
            return sum;
        }
        // Add smaller digits recursively
        PartialSum sum = addListsHelper(l1.next, l2.next);

        // Add carry to current data
        int val = sum.carry + l1.data + l2.data;

        // Insert sum of current digits
        LinkedListNode fullResult = insertBefore(sum.sum, val % 10);

        // Return sum so far, and the carry value
        sum.sum = fullResult;
        sum.carry = val / 10;

        return sum;
    }

    // Pad the list with zeros
    LinkedListNode padList(LinkedListNode l, int padding) {
        LinkedListNode head = l;
        for (int i = 0; i < padding; i++) {
            head = insertBefore(head, 0);
        }
        return head;
    }

    // Helper function to insert node in the front of a linked list
    LinkedListNode insertBefore(LinkedListNode list, int data) {
        LinkedListNode node = new LinkedListNode(data);
        if (list != null) {
            node.next = list;
        }
        return node;
    }

    public static void main(String[] args) {
        SumLists sumLists = new SumLists();

        int [] list1Values = {6, 1, 7};
        LinkedListNode list1 = Utils.createCustomTestList(list1Values);

        int [] list2Values = {2, 9, 5};
        LinkedListNode list2 = Utils.createCustomTestList(list2Values);

        LinkedListNode result = sumLists.addLists(list1, list2);
        Utils.printList(result);
    }
}
