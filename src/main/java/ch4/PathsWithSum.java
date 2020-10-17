package ch4;

import java.util.HashMap;

public class PathsWithSum {

    // Solution #1 Brute force
    int countPathsWithSum(TreeNode root, int targetSum) {
        if (root == null) return 0;

        // Count paths with sum starting from the root
        int pathsFromRoot = countPartsWithSumFromNode(root, targetSum, 0);

        // Try the nodes on the left and the right
        int pathsOnLeft = countPathsWithSum(root.left, targetSum);
        int pathsOnRight = countPathsWithSum(root.right, targetSum);

        return pathsFromRoot + pathsOnLeft + pathsOnRight;
    }

    int countPartsWithSumFromNode(TreeNode node, int targetSum, int currentSum) {
        if (node == null) return 0;

        currentSum += node.value;

        int totalPaths = 0;
        if (currentSum == targetSum) {
            totalPaths++;
        }

        totalPaths += countPartsWithSumFromNode(node.left, targetSum, currentSum);
        totalPaths += countPartsWithSumFromNode(node.right, targetSum, currentSum);

        return totalPaths;
    }

    int countPathsWithSum2(TreeNode root, int targetSum) {
        return countPathsWithSum2(root, targetSum, 0, new HashMap<Integer, Integer>());
    }

    int countPathsWithSum2(TreeNode node, int targetSum, int runningSum, HashMap<Integer, Integer> pathCount) {
        if (node == null) return 0; // base case

        // Count paths with sum ending at the current node
        runningSum += node.value;
        int sum = runningSum - targetSum;
        int totalPaths = pathCount.getOrDefault(sum, 0);
        
        // If running sum equals target sum, then one additional path starts at root, add this in path
        if (runningSum == targetSum) {
            totalPaths++;
        }
        
        // Increment pathCount, recurse, then decrement pathCount
        incrementHashTable(pathCount, runningSum, 1); // Increment pathcount
        totalPaths += countPathsWithSum2(node.left, targetSum, runningSum, pathCount);
        totalPaths += countPathsWithSum2(node.right, targetSum, runningSum, pathCount);
        incrementHashTable(pathCount, runningSum, -1);

        return totalPaths;
    }

    void incrementHashTable(HashMap<Integer, Integer> hashTable, int key, int delta) {
        int newCount = hashTable.getOrDefault(key, 0) + delta;
        if (newCount == 0) {
            hashTable.remove(key);
        } else {
            hashTable.put(key, newCount);
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode = Utils.generateTestTree();
        PathsWithSum pathsWithSum = new PathsWithSum();

        int i = pathsWithSum.countPathsWithSum2(treeNode, 8);
        System.out.println(i);
    }
}
