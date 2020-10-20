package ch8;

public class MagicIndex {

    int magicFast(int [] array) {
        return magicFast(array, 0, array.length - 1);
    }

    public int magicFast(int [] array, int start, int end) {
        if (end < start) {
            return -1;
        }

        int mid = (start + end) / 2;
        if (array[mid] == mid) {
            return mid;
        } else if(array[mid] > mid) {
            return magicFast(array, start, mid - 1);
        } else {
            return magicFast(array, mid + 1, end);
        }
    }

    int magicFast2(int [] array) {
        return magicFast2(array, 0, array.length - 1);
    }

    int magicFast2(int [] array, int start, int end) {
        if (end < start) return -1;

        int midIndex = (start + end) / 2;
        int midValue = array[midIndex];
        if (midIndex == midValue) {
            return midIndex;
        }

        // search left
        int leftIndex = Math.min(midIndex - 1, midValue);
        int left = magicFast2(array, start, leftIndex);
        if (left >= 0) {
            return left;
        }

        // search right
        int rightIndex = Math.max(midIndex + 1, midValue);
        int right = magicFast2(array, rightIndex, end);
        return right;
    }

    public static void main(String[] args) {
        MagicIndex magicIndex = new MagicIndex();
        int [] test = {-40, -20, -1, 1, 2, 3, 5, 7, 9, 12, 13};
        System.out.println(magicIndex.magicFast2(test));
    }
}
