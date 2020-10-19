package ch5;

public class BitInsertion {

    int updateBits(int n, int m, int i, int j) {
        // Create a mask to clear bits i, through j, in n.
        // Example: i = 2, j = 4. Result should be 11100011
        // For simplicity, we'll use just 8 bits for the example
        int allones = ~0;
        System.out.println(allones);

        // 1s before position j, then 0s. left = 11100000
        int left = allones << (j + 1);
        System.out.println(Integer.toBinaryString(left));

        // 1s after position i right = 00000011
        int right = ((1 << i) - 1);
        System.out.println(Integer.toBinaryString(right));

        // All 1s, except for 0s between i and j. mask = 11100011
        int mask = left | right;
        System.out.println("Mask: " + Integer.toBinaryString(mask));

        // Clear bits j through i then put m in there
        int n_cleared = n & mask;
        System.out.println("n cleared: " + Integer.toBinaryString(n_cleared));
        int m_shifted = m << i;
        System.out.println("m shifted: " + Integer.toBinaryString(m_shifted));

        return n_cleared | m_shifted;
    }

    public static void main(String[] args) {
        BitInsertion bitInsertion = new BitInsertion();

        int i = bitInsertion.updateBits(1024, 19, 2, 6);
        System.out.println(Integer.toBinaryString(i));
    }

}
