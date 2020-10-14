package ch2;

import java.util.Stack;

public class Palindrome {

    boolean isPalindrome(LinkedListNode head) {
        LinkedListNode reversed = reverseAndClone(head);
        return isEqual(head, reversed);
    }

    private LinkedListNode reverseAndClone(LinkedListNode node) {
        LinkedListNode head = null;
        while (node != null) {
            LinkedListNode n = new LinkedListNode(node.data);
            n.next = head;
            head = n;
            node = node.next;
        }
        return head;
    }

    boolean isEqual(LinkedListNode one, LinkedListNode two) {
        while (one != null && two != null) {
            if (one.data != two.data) {
                return false;
            }
            one = one.next;
            two = two.next;
        }
        return one == null && two == null;
    }

    // #2 Iterative Approach
    boolean isPalindromeIterative(LinkedListNode head) {
        LinkedListNode fast = head;
        LinkedListNode slow = head;

        Stack<Integer> stack = new Stack<>();

        // Push elements from first half of linked list onto stack. When fast runner
        // (which is moving at 2x speed) reaches the end of the linked list, then we
        // know we're at the middle
        while (fast != null && fast.next != null) {
            stack.push(slow.data);
            slow = slow.next;
            fast = fast.next.next;
        }

        // Has odd number of elements, so skip the middle element
        if (fast != null) {
            slow = slow.next;
        }

        while (slow != null) {
            int top = stack.pop().intValue();

            // If values are different, then it's not a palindrome
            if (top != slow.data) {
                return false;
            }
            slow = slow.next;
        }
        return true;
    }

    // #3 Recursive
    class Result {
        public LinkedListNode node;
        public boolean result;

        public Result(LinkedListNode node, boolean result) {
            this.node = node;
            this.result = result;
        }
    }

    boolean isPalindromeRecursive(LinkedListNode head) {
        int length = Utils.length(head);
        Result p = isPalindromeRecurse(head, length);
        return p.result;
    }

    Result isPalindromeRecurse(LinkedListNode head, int length) {
        if (head == null || length <= 0) { // Even number of nodes
            return new Result(head, true);
        } else if(length == 1) { // Odd number of nodes
            return new Result(head, true);
        }

        // Recurse on sublist
        Result res = isPalindromeRecurse(head.next, length - 2);

        // If child calls are not a palindrome, pass a back up a failure
        if (!res.result || res.node == null) {
            return res;
        }

        // Check if matches corresponding node on other side
        res.result = (head.data == res.node.data);

        // Return corresponding node
        res.node = res.node.next;

        return res;
    }

    public static void main(String[] args) {
        Palindrome palindrome = new Palindrome();

        int [] data = {0, 1, 2, 1, 0};
        LinkedListNode test = Utils.createCustomTestList(data);

        System.out.println("Is Palindrome? " + palindrome.isPalindromeRecursive(test));
    }
}
