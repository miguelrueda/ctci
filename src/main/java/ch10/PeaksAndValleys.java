package ch10;

import java.util.Arrays;

public class PeaksAndValleys {

    void sortValleyPeak(int [] array) {
        Arrays.sort(array);

        for (int i = 1; i < array.length; i += 2) {
            swap(array, i - 1, i);
        }
    }

    void swap(int [] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }

    void sortValleyPeak2(int [] array) {
        for (int i = 1; i < array.length; i += 2) {
            int biggestIndes = maxIndex(array, i - 1, i, i + 1);
            if (i != biggestIndes) {
                swap(array, i, biggestIndes);
            }
        }
    }

    int maxIndex(int [] array, int a, int b, int c) {
        int len = array.length;

        int aValue = a >= 0 && a < len ? array[a] : Integer.MIN_VALUE;
        int bValue = b >= 0 && b < len ? array[b] : Integer.MIN_VALUE;
        int cValue = c >= 0 && c < len ? array[c] : Integer.MIN_VALUE;

        int max = Math.max(aValue, Math.max(bValue, cValue));
        if (aValue == max) return a;
        else if (bValue == max) return b;
        else return c;
    }

    public static void main(String[] args) {
        int [] array = {0, 9, 1, 8, 7, 4};

        PeaksAndValleys peaksAndValleys = new PeaksAndValleys();
        peaksAndValleys.sortValleyPeak(array);

        System.out.println(Arrays.toString(array));
    }
}
