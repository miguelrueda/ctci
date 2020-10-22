package ch10;

import java.util.Arrays;

public class SortedMerge {

    void merge(int [] a, int [] b, int lastA, int lastB) {
        int indexA = lastA - 1; // Index of last element in array a
        int indexB = lastB - 1; // Index of last element in array b
        int indexMerged = lastB + lastA + 1; // end of merged array
        System.out.println("Index merged " + indexMerged);

        //  Merge a and b, starting from the last element in each
        while (indexB >= 0) {
            // end of a is > than end of b
            if (indexA >= 0 && a[indexA] > b[indexB]) {
                a[indexMerged] = a[indexA]; // copy element
                indexA--;
            } else {
                a[indexMerged] = b[indexB]; // copy element
                indexB--;
            }
            indexMerged--; // move indices
        }
    }

    public static void main(String[] args) {
        SortedMerge sortedMerge = new SortedMerge();
        int insertIndex = 0;
        int [] a = new int[200];
        for (int i = 0; i <= 10; i += 2) {
            a[insertIndex] = i;
            insertIndex++;
        }
        System.out.println(Arrays.toString(a));
        insertIndex = 0;
        int [] b = new int[5];
        for (int i = 1; i < 10; i += 2) {
            b[insertIndex] = i;
            insertIndex++;
        }
        System.out.println(Arrays.toString(b));

        sortedMerge.merge(a, b, 5, b.length);

        System.out.println(Arrays.toString(a));
    }
}
