package ch4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class ListOfDepths {

    void createLevelLinkedList(TreeNode root, ArrayList<LinkedList<TreeNode>> lists, int level) {
        if (root == null) return; // base case

        LinkedList<TreeNode> list = null;
        if (lists.size() == level) { // Level not contained in list
            list = new LinkedList<>();
            // Levels are always traversed in order. So, if this is the first time we've visited leveli,
            // we must have seen levels 0 through i - 1. We can therefore safely add the level at the end-
            lists.add(list);
        } else {
            list = lists.get(level);
        }
        list.add(root);

        createLevelLinkedList(root.left, lists, level + 1);
        createLevelLinkedList(root.right, lists, level + 1);
    }

    ArrayList<LinkedList<TreeNode>> createLevelLinkedList(TreeNode root) {
        ArrayList<LinkedList<TreeNode>> lists = new ArrayList<>();
        createLevelLinkedList(root, lists, 0);
        return lists;
    }

    ArrayList<LinkedList<TreeNode>> createLevelLinkedList2(TreeNode root) {
        ArrayList<LinkedList<TreeNode>> result = new ArrayList<>();
        // Visit the root
        LinkedList<TreeNode> current = new LinkedList<>();
        if (root != null) {
            current.add(root);
        }
        while (current.size() > 0) {
            result.add(current); // Add previous level
            LinkedList<TreeNode> parents = current;
            current = new LinkedList<>();
            for (TreeNode parent: parents) {
                // Visit the childrem
                if (parent.left != null) {
                    current.add(parent.left);
                }
                if (parent.right != null) {
                    current.add(parent.right);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ListOfDepths listOfDepths = new ListOfDepths();
        ArrayList<LinkedList<TreeNode>> levelLinkedList = listOfDepths.createLevelLinkedList2(Utils.generateTestTree());
        for (LinkedList<TreeNode> list: levelLinkedList) {
            System.out.println("start");
            Iterator<TreeNode> iterator = list.iterator();
            while (iterator.hasNext()) {
                System.out.println(iterator.next().value);
            }
            System.out.println("end");
        }
    }
}
