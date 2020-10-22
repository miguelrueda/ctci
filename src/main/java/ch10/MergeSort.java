package ch10;

import java.util.Arrays;

public class MergeSort {

    void mergeSort(int [] array) {
        int [] helper = new int[array.length];
        mergeSort(array, helper, 0, array.length - 1);
    }

    void mergeSort(int [] array, int [] helper, int low, int high) {
        System.out.println("Called for" + Arrays.toString(array) + " Helper: " + Arrays.toString(helper) + " low: " + low + " high: " + high);
        if (low < high) {
            int middle = (low + high) / 2;
            mergeSort(array, helper, low, middle); // sort left half
            mergeSort(array, helper, middle + 1, high); // sort right half
            merge(array, helper, low, middle, high); // merge them
        }
    }

    void merge(int [] array, int [] helper, int low, int middle, int high) {
        System.out.println("Called for " + Arrays.toString(helper) + " low " + low + " middle: " + middle + " high " + high);
        // Copy both halves into a helper array
        for (int i = low; i <= high; i++) {
            helper[i] = array[i];
        }

        int helperLeft = low;
        int helperRight = middle + 1;
        int current = low;

        // Iterate through helper array. Compare the left and right half, copying back the smaller
        // element from the two halves into the original array
        while (helperLeft <= middle && helperRight <= high) {
            if (helper[helperLeft] <= helper[helperRight]) {
                array[current] = helper[helperLeft];
                helperLeft++;
            } else { // if right element is smaller than left element
                array[current] = helper[helperRight];
                helperRight++;
            }
            current++;
        }

        // Copy the rest of the left side ofthe array into the target array
        int remaining = middle - helperLeft;
        for (int i = 0; i < remaining; i++) {
            array[current + i] = helper[helperLeft + i];
        }
    }

    public static void main(String[] args) {
        int [] array = {1, 4, 5, 2, 8, 9};
        MergeSort mergeSort = new MergeSort();
        mergeSort.mergeSort(array);
        System.out.println(Arrays.toString(array));
    }
}
