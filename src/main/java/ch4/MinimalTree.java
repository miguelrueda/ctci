package ch4;

public class MinimalTree {

    TreeNode createMinimalBST(int array[]) {
        return createMinimalBST(array, 0, array.length - 1);
    }

    TreeNode createMinimalBST(int [] array, int start, int end) {
        if (end < start) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode n = new TreeNode(array[mid]);
        n.left = createMinimalBST(array, start, mid - 1);
        n.right = createMinimalBST(array, mid + 1, end);

        return n;
    }

    public static void main(String[] args) {
        int [] array = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };

        MinimalTree minimalTree = new MinimalTree();
        TreeNode treeNode = minimalTree.createMinimalBST(array);
        Utils.printPreOrder(treeNode);
    }

}
