package ch4;

import java.util.Random;

public class RandomTreeNode {

    private int data;
    public RandomTreeNode left;
    public RandomTreeNode right;
    private int size = 0;

    public RandomTreeNode(int d) {
        data = d;
        size = 1;
    }

    public RandomTreeNode getRandomNode() {
        int leftSize = left == null ? 0 : left.size;
        Random random = new Random();
        int index = random.nextInt(size);
        if (index < leftSize) {
            return left.getRandomNode();
        } else if (index == leftSize) {
            return this;
        } else {
            return right.getRandomNode();
        }
    }

    public void insertInOrder(int d) {
        if (d <= data) {
            if (left == null) {
                left = new RandomTreeNode(d);
            } else {
                left.insertInOrder(d);
            }
        } else {
            if (right == null) {
                right = new RandomTreeNode(d);
            } else {
                right.insertInOrder(d);
            }
        }
        size++;
    }

    public int size() {
        return size;
    }

    public int data() {
        return data;
    }

    public RandomTreeNode find(int d) {
        if (d == data) {
            return this;
        } else if(d <= data) {
            return left != null ? left.find(d) : null;
        } else if (d > data) {
            return right != null ? right.find(d) : null;
        }
        return null;
    }

    public RandomTreeNode getIthNode(int i) {
        int leftSize = left == null ? 0 : left.size;
        if (i < leftSize) {
            return left.getIthNode(i);
        } else if (i == leftSize) {
            return this;
        } else {
            // skipping over leftsize + 1 nodes, so subtract them
            return right.getIthNode(i - (leftSize + 1));
        }
    }

    static RandomTreeNode createMinimalBST(int array[]) {
        return createMinimalBST(array, 0, array.length - 1);
    }

    static RandomTreeNode createMinimalBST(int [] array, int start, int end) {
        if (end < start) {
            return null;
        }
        int mid = (start + end) / 2;
        RandomTreeNode n = new RandomTreeNode(array[mid]);
        n.left = createMinimalBST(array, start, mid - 1);
        n.right = createMinimalBST(array, mid + 1, end);

        return n;
    }

    class RandomTree {
        RandomTreeNode root = null;

        public int size() {
            return root == null ? 0 : root.size;
        }

        public RandomTreeNode getRandomNode() {
            if (root == null) return null;

            Random random = new Random();
            int i = random.nextInt(size());
            return root.getIthNode(i);
        }

        public void insertInOrder(int value) {
            if (root == null) {
                root = new RandomTreeNode(value);
            } else {
                root.insertInOrder(value);
            }
        }
    }

    public static void main(String[] args) {
        int [] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        RandomTreeNode minimalBST = RandomTreeNode.createMinimalBST(array);

    }
}
