package ch4;

public class CheckSubtree {

    boolean containsTree(TreeNode t1, TreeNode t2) {
        StringBuilder string1 = new StringBuilder();
        StringBuilder string2 = new StringBuilder();

        getOrderString(t1, string1);
        getOrderString(t2, string2);
        System.out.println(string1.toString());
        System.out.println(string2.toString());

        return string1.indexOf(string2.toString()) != -1;
    }

    void getOrderString(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append(" X ");
            return;
        }

        sb.append(node.value + " ");
        getOrderString(node.left, sb);
        getOrderString(node.right, sb);
    }

    boolean containsTree2(TreeNode t1, TreeNode t2) {
        if (t2 == null) return true; // The empty tree is always a subtree
        return subtree(t1, t2);
    }

    boolean subtree(TreeNode r1, TreeNode r2) {
        if (r1 == null) {
            return false; // big tree empty & subtree still not found
        } else if (r1.value == r2.value && matchTree(r1, r2)) {
            return true;
        }
        return subtree(r1.left, r2) || subtree(r1.right, r2);
    }

    boolean matchTree(TreeNode r1, TreeNode r2) {
        if (r1 == null && r2 == null) {
            return true; // nothing left in the subtree
        } else if(r1 == null || r2 == null) {
            return false; // exactly tree is empty, therefore trees don't match
        } else if (r1.value != r2.value) {
            return false; // data doesn't match
        } else {
            return matchTree(r1.left, r2.left) && matchTree(r1.right, r2.right);
        }
    }

    public static void main(String[] args) {
        CheckSubtree checkSubtree = new CheckSubtree();

        TreeNode treeNode = Utils.generateTestTree();
        int [] array = { 6, 7, 8 };

        Utils.printPreOrder(treeNode);
        System.out.println();
        MinimalTree minimalTree = new MinimalTree();
        TreeNode treeNode2 = minimalTree.createMinimalBST(array);
        Utils.printPreOrder(treeNode2);
        System.out.println(checkSubtree.containsTree2(treeNode, treeNode2));
    }
}
