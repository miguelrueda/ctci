package ch4;

public class CheckBalanced {

    int getHeight(TreeNode root) {
        if (root == null) return -1;

        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }

    boolean isBalanced(TreeNode root) {
        if (root == null) return true; // base case

        System.out.println(getHeight(root.left));
        System.out.println(getHeight(root.right));
        int heightDiff = getHeight(root.left) - getHeight(root.right);
        if (Math.abs(heightDiff) > 1) {
            return false;
        } else {
            return isBalanced(root.left) && isBalanced(root.right);
        }
    }

    int checkHeight(TreeNode root) {
        if (root == null) return -1;

        int leftHeight = checkHeight(root.left);
        if (leftHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE; // Pass Error Up
        int rightHeight = checkHeight(root.right);
        if (rightHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE; // Pass Error Up

        int heightDiff = leftHeight - rightHeight;
        if (Math.abs(heightDiff) > 1) {
            return Integer.MIN_VALUE;
        } else {
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

    boolean isBalanced2(TreeNode root) {
        return checkHeight(root) != Integer.MIN_VALUE;
    }

    public static void main(String[] args) {
        CheckBalanced checkBalanced = new CheckBalanced();
        TreeNode treeNode = Utils.generateTestTree();

        System.out.println(checkBalanced.isBalanced2(treeNode));
    }
}
