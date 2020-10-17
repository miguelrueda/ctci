package ch4;

public class FirstCommonAncestor {

    TreeNode commonAncestor(TreeNode p, TreeNode q) {
        int delta = depth(p) - depth(q); // get difference in depths
        TreeNode first = delta > 0 ? q : p; // get shallower node
        TreeNode second = delta > 0 ? p : q; // get deeper node
        second = goUpBy(second, Math.abs(delta)); // Move deeper node up

        // Find where paths intersect
        while (first != second && first != null && second != null) {
            first = first.parent;
            second = second.parent;
        }
        return first == null || second == null ? null : first;
    }

    TreeNode goUpBy(TreeNode node, int delta) {
        while (delta > 0 && node != null) {
            node = node.parent;
            delta--;
        }
        return node;
    }

    int depth(TreeNode node) {
        int depth = 0;
        while (node != null) {
            node = node.parent;
            depth++;
        }
        return depth;
    }

    TreeNode commonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        // Check if either node is not in the tree or if one covers the other
        if (!covers(root, p) || !covers(root, q)) {
            return null;
        } else if (covers(p, q)) {
            return p;
        } else if(covers(q, p)) {
            return q;
        }

        // Traverse upwards until you find a node that covers q
        TreeNode sibling = getSibling(p);
        TreeNode parent = p.parent;
        while (!covers(sibling, q)) {
            sibling = getSibling(parent);
            parent = parent.parent;
        }
        return parent;
    }

    boolean covers(TreeNode root, TreeNode p) {
        if (root == null) return false;
        if (root == p) return true;

        return covers(root.left, p) || covers(root.right, p);
    }

    TreeNode getSibling(TreeNode node) {
        if (node == null || node.parent == null) {
            return null;
        }
        TreeNode parent = node.parent;
        return parent.left == node ? parent.right : parent.left;
    }

    TreeNode commonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Error check one node is not in the tree
        if (!covers(root, p) || !covers(root, q)) {
            return null;
        }
        return ancestorHelper(root, p, q);
    }

    TreeNode ancestorHelper(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        boolean pIsOnLeft = covers(root.left, p);
        boolean qIsOnLeft = covers(root.left, q);

        if (pIsOnLeft != qIsOnLeft) {
            return root;
        }
        TreeNode childSide = pIsOnLeft ? root.left : root.right;
        return ancestorHelper(childSide, p, q);
    }

    TreeNode commonAncestor3(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root == p && root == q) return root;

        TreeNode x = commonAncestor3(root.left, p, q);
        if (x != null && x != p && x != q) { //Already found ancestor
            return x;
        }

        TreeNode y = commonAncestor3(root.right, p, q);
        if (y != null && y != p && y != q) { // Already found ancestor
            return y;
        }

        if (x != null && y != null) { // p and q found in diff. subtrees
            return root; // This is the common ancestor
        } else if(root == p || root == q) {
            return root;
        } else {
            return x == null ? y : x; // Return the non-null value
        }
    }

    public static void main(String[] args) {

    }
}
