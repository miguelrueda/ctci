package ch10;

class RankNode {
    public int left_size = 0;
    public RankNode left, right;
    public int data = 0;

    public RankNode(int d) {
        data = d;
    }

    public void insert(int d) {
        if (d <= data) {
            if (left != null) left.insert(d);
            else left = new RankNode(d);
            left_size++;
        } else {
            if (right != null) right.insert(d);
            else right = new RankNode(d);
        }
    }

    public int getRank(int d) {
        if (d == data) {
            return left_size;
        } else if (d < data) {
            if (left == null) return -1;
            else return left.getRank(d);
        } else {
            int right_rank = right == null ? -1 : right.getRank(d);
            if (right_rank == -1) return -1;
            else return left_size + 1 + right_rank;
        }
    }
}

public class RankStream {

    RankNode root = null;

    void track(int number) {
        if (root == null) {
            root = new RankNode(number);
        } else {
            root.insert(number);
        }
    }

    int getRankOfNumber(int number) {
        return root.getRank(number);
    }

    public static void main(String[] args) {
        RankStream rankStream = new RankStream();

        rankStream.track(5);
        rankStream.track(10);
        rankStream.track(13);
        rankStream.track(15);
        rankStream.track(20);
        rankStream.track(23);
        rankStream.track(24);
        rankStream.track(25);

        System.out.println(rankStream.getRankOfNumber(20));
    }
}
