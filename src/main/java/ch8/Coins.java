package ch8;

public class Coins {

    private int makeChange(int amount, int [] denoms, int index) {
        if (index >= denoms.length - 1) return 1; // last denom
        int denomAmount = denoms[index];
        int ways = 0;
        for (int i = 0; i * denomAmount <= amount; i++) {
            int amountRemaining = amount - i * denomAmount;
            ways += makeChange(amountRemaining, denoms, index + 1);
        }
        return ways;
    }

    int makeChange(int n) {
        int [] denoms = { 25, 10, 5, 1 };
        return makeChange(n, denoms, 0);
    }

    int makeChange2(int n) {
        int [] denoms = { 25, 10, 5, 1 };
        int [][] map = new int[n + 1][denoms.length]; // precomputed vals
        return makeChange2(n, denoms, 0, map);
    }

    int makeChange2(int amount, int [] denoms, int index, int [][] map) {
        if (map[amount][index] > 0) { // Retrieve value
            return map[amount][index];
        }
        if (index >= denoms.length - 1) return 1;
        int denomAmount = denoms[index];
        int ways = 0;
        for (int i = 0; i * denomAmount <= amount; i++) {
            // go to next denom, assuming i coins of denomAmount
            int amountRemaining = amount - i * denomAmount;
            ways += makeChange2(amountRemaining, denoms, index + 1, map);
        }
        map[amount][index] = ways;
        return ways;
    }

    public static void main(String[] args) {
        Coins coins =  new Coins();
        int i = coins.makeChange2(10);
        System.out.println(i);
    }
}
