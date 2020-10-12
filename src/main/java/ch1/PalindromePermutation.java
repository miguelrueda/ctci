package ch1;

public class PalindromePermutation {

    boolean isPermutationOfPalindrome(String phrase) {
        int [] table = buildCharFrequencyTable(phrase);
        return checkMaxOneOdd(table);
    }

    /**
     * Count how many times each character appears
     * @param phrase
     * @return
     */
    public int[] buildCharFrequencyTable(String phrase) {
        int [] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
        for (char c: phrase.toCharArray()) {
            int x = getCharNumber(c);
            if (x != -1) {
                table[x]++;
            }
        }
        return table;
    }

    /**
     * Map each character to a number, a->0, b ->1, c->2, etc.
     * @param c
     * @return
     */
    public int getCharNumber(char c) {
        int a = Character.getNumericValue('a');
        int z = Character.getNumericValue('z');
        int val = Character.getNumericValue(c);

        if (a <= val && val <= z) {
            return val - a;
        }
        return -1;
    }

    public boolean checkMaxOneOdd(int [] table) {
        boolean foundOdd = false;
        for (int count : table) {
            if (count % 2 == 1) {
                if (foundOdd) {
                    return false;
                }
                foundOdd = true;
            }
        }
        return true;
    }

    boolean isPermutationOfPalindrome2(String phrase) {
        int bitVector = createBitVector(phrase);
        return bitVector == 0 || checkExactlyOneBitSet(bitVector);
    }

    /**
     * Create a bit vector for the string, for each letter with value i, toggle the ith bit
     * @param phrase
     * @return
     */
    int createBitVector(String phrase) {
        int bitVector = 0;
        for (char c: phrase.toCharArray()) {
            int x = getCharNumber(c);
            bitVector = toggle(bitVector, x);
        }
        return bitVector;
    }

    /**
     * Toggle the ith bit in the integer
     * @param bitVector
     * @param index
     * @return
     */
    int toggle(int bitVector, int index) {
        if (index < 0) return bitVector;

        int mask = 1 << index;
        if ((bitVector & mask) == 0) {
            bitVector |= mask;
        } else
            bitVector &= ~mask;

        return bitVector;
    }

    boolean checkExactlyOneBitSet(int bitVector) {
        return (bitVector & (bitVector - 1)) == 0;
    }

    public static void main(String[] args) {
        PalindromePermutation palindromePermutation = new PalindromePermutation();
        System.out.println(palindromePermutation.isPermutationOfPalindrome2("Tact Coa"));
    }
}
