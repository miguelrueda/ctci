package ch10;

import java.util.Arrays;

public class QuickSort {

    void quickSort(int [] arr, int left, int right) {
        int index = partition(arr, left, right);
        System.out.println("Partition index  " + index);
        if (left < index - 1) { // sort left half
            quickSort(arr, left, index - 1);
        }
        if (index < right) { // sort right half
            quickSort(arr, index, right);
        }
    }

    int partition(int [] arr, int left, int right) {
        int pivot = arr[(left + right) / 2]; // Pick pivot point
        while (left <= right) {
            // Find element on left that should be on right
            while (arr[left] < pivot) left++;

            // Find element on right that should be on left
            while (arr[right] > pivot) right--;

            // Swap elements, and move left and right indices
            if (left <= right) {
                swap(arr, left, right); // swap elements
                left++;
                right--;
            }
        }
        return left;
    }

    void swap(int [] arr, int left, int right) {
        int tmp = arr[left];
        arr[left] = arr[right];
        arr[right] = tmp;
    }

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int [] arr = {1, 2, 8, 4, 6, 9};
        quickSort.quickSort(arr, 0, arr.length - 1);

        System.out.println(Arrays.toString(arr));
    }
}
