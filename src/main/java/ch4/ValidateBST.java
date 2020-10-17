package ch4;

public class ValidateBST {

    Integer last_printed = null;
    boolean checkBST(TreeNode n) {
        if (n == null) return true;

        // Check recurse left
        if (!checkBST(n.left)) return false;

        // Check current
        if (last_printed!= null && n.value <= last_printed) {
            return false;
        }
        last_printed = n.value;

        // Check recurse right
        if (!checkBST(n.right)) return false;

        return true;
    }

    boolean checkBST2(TreeNode n) {
        return checkBST2(n, null, null);
    }

    boolean checkBST2(TreeNode n, Integer min, Integer max) {
        if (n == null) {
            return true;
        }
        if ((min != null && n.value <= min) || (max != null && n.value > max)) {
            return false;
        }
        if (!checkBST2(n.left, min, n.value) || !checkBST2(n.right, n.value, max)) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        ValidateBST validateBST = new ValidateBST();
        TreeNode treeNode = Utils.generateTestTree();

        System.out.println(validateBST.checkBST2(treeNode));
    }
}
