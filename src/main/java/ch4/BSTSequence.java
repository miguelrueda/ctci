package ch4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class BSTSequence {

    ArrayList<LinkedList<Integer>> allSequences(TreeNode node) {
        ArrayList<LinkedList<Integer>> result = new ArrayList<>();

        if (node == null) {
            result.add(new LinkedList<Integer>());
            return result;
        }

        LinkedList<Integer> prefix = new LinkedList<Integer>();
        prefix.add(node.value);

        // Recurse on the left and right subtrees
        ArrayList<LinkedList<Integer>> leftSeq = allSequences(node.left);
        ArrayList<LinkedList<Integer>> rightSeq = allSequences(node.right);

        // Weave together each list from the left and right sides
        for (LinkedList<Integer> left: leftSeq) {
            for (LinkedList<Integer> right: rightSeq) {
                ArrayList<LinkedList<Integer>> weaved = new ArrayList<>();
                weaveLists(left, right, weaved, prefix);
                result.addAll(weaved);
            }
        }
        return result;
    }

    // Weave lists together in all possible ways. This algorithm works by removing the head from one list, recursing,
    // and then doing the same thing wieh the other list
    void weaveLists(LinkedList<Integer> first, LinkedList<Integer> second,
                    ArrayList<LinkedList<Integer>> results, LinkedList<Integer> prefix) {
        // One list is empty. Add remainder to [a cloned] prefix and store result
        if (first.size() == 0 || second.size() == 0) {
            LinkedList<Integer> result = (LinkedList<Integer>) prefix.clone();
            result.addAll(first);
            result.addAll(second);
            results.add(result);
            return;
        }

        // Recurse with head of first added to the prefix. Removing the head will damage first, so we'll
        // need to put it back where we found it afterwards
        int headFirst = first.removeFirst();
        prefix.addLast(headFirst);
        weaveLists(first, second, results, prefix);
        prefix.removeLast();
        first.addFirst(headFirst);

        // Do the same thing with second, damagind and then restoring the list.
        int headSecond = second.removeFirst();
        prefix.addLast(headSecond);
        weaveLists(first, second, results, prefix);
        prefix.removeLast();
        second.addFirst(headSecond);
    }

    public static void main(String[] args) {
        BSTSequence bstSequence = new BSTSequence();
        TreeNode treeNode = Utils.generateTestTree();

        ArrayList<LinkedList<Integer>> linkedLists = bstSequence.allSequences(treeNode);
        for (LinkedList<Integer> list : linkedLists) {
            Iterator<Integer> iterator = list.iterator();
            System.out.print("{");
            while (iterator.hasNext()) {
                Integer next = iterator.next();
                System.out.print(next + " - ");
            }
            System.out.print("}");
        }
    }
}
