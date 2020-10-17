package ch4;

public class Utils {

    public static void printInOrder(TreeNode node) {
        if (node !=  null) {
            printInOrder(node.left);
            System.out.print( " <- " + node.value + " -> ");
            printInOrder(node.right);
        }
    }

    public static void printPreOrder(TreeNode node) {
        if (node !=  null) {
            System.out.print(node.value);
            printInOrder(node.left);
            printInOrder(node.right);
        }
    }

    public static void printPostOrder(TreeNode node) {
        if (node !=  null) {
            printInOrder(node.left);
            printInOrder(node.right);
            System.out.print(node.value);
        }
    }

    public static TreeNode generateTestTree() {
        int [] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

        MinimalTree minimalTree = new MinimalTree();
        TreeNode treeNode = minimalTree.createMinimalBST(array);
        Utils.printPreOrder(treeNode);
        System.out.println();
        return treeNode;
    }

}
