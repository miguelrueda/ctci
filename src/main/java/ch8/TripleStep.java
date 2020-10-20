package ch8;

import java.util.Arrays;

public class TripleStep {

    public int countWays(int n) {
        if (n < 0) {
            return 0;
        } else if (n == 0) {
            return 1;
        } else {
            return countWays(n - 1) + countWays(n - 2) + countWays(n - 3);
        }
    }

    public int countWays2(int n) {
        int [] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return countWays(n, memo);
    }

    public int countWays(int n, int [] memo) {
        if (n < 0) {
            return 0;
        } else if (n == 0) {
            return 1;
        } else if (memo[n] > -1) {
            return memo[n];
        } else {
            memo[n] = countWays(n - 1, memo) + countWays(n - 2, memo) + countWays(n - 3, memo);
            return memo[n];
        }
    }

    public static void main(String[] args) {
        TripleStep tripleStep = new TripleStep();
        System.out.println(tripleStep.countWays2(37));
    }
}
