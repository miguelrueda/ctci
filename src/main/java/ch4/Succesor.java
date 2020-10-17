package ch4;

public class Succesor {

    TreeNode inorderSucc(TreeNode n) {
        if (n == null) return null;

        // Found right children -> return leftmost node of right subtree
        if (n.right != null) {
            return leftMostChild(n.right);
        } else {
            TreeNode q = n;
            TreeNode x = q.parent;
            // Go up until we're on left instead of right
            while (x != null && x.left != q) {
                q = x;
                x = x.parent;
            }
            return x;
        }
    }

    TreeNode leftMostChild(TreeNode n) {
        if (n == null) {
            return null;
        }
        while (n.left != null) {
            n = n.left;
        }

        System.out.println("--> " + n.value);
        return n;
    }

    public static void main(String[] args) {
        Succesor succesor = new Succesor();
        TreeNode treeNode = Utils.generateTestTree();

        TreeNode treeNode1 = succesor.inorderSucc(treeNode);
        Utils.printInOrder(treeNode1);
    }
}
