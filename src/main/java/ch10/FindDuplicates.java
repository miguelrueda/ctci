package ch10;

class Bitset {
    int [] bitset;

    public Bitset(int size) {
        bitset = new int[(size >> 5) + 1]; // Divide by 32
        System.out.println(size >> 5);
        System.out.println("Size of the array " + Integer.toBinaryString((size >> 5) + 1));
    }

    boolean get(int pos) {
        System.out.println("GET");
        System.out.println("POS " + pos);
        int wordNumber = (pos >> 5);
        System.out.println(wordNumber);
        System.out.println(Integer.toBinaryString(wordNumber));
        int bitNumber = (pos & 0x1F); // mod 32
        System.out.println("End GET");
        return (bitset[wordNumber] & (1 << bitNumber)) != 0;
    }

    void set(int pos) {
        int wordNumber = (pos >> 5); // divide by 32
        int bitNumber = (pos & 0x1F); // mod 32
        bitset[wordNumber] |= 1 << bitNumber;
    }
}

public class FindDuplicates {

    void checkDuplicates(int [] array) {
        Bitset bs = new Bitset(32000);
        for (int i = 0; i < array.length; i++) {
            int num = array[i];
            int num0 = num - 1; // bitset starts at 0, numbers start at 1
            if (bs.get(num0)) {
                System.out.println(num);
            } else {
                bs.set(num0);
            }
        }
    }

    public static void main(String[] args) {
        int [] array = {
            1,
            2,3,4,5,6,3000, 7,8,9,9,9,9,1,3,5,4,1, 3000
        };
        FindDuplicates findDuplicates = new FindDuplicates();
        findDuplicates.checkDuplicates(array);
    }
}
