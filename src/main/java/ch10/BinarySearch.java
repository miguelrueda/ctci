package ch10;

public class BinarySearch {

    int binarySearch(int [] a, int x) {
        int low = 0;
        int high = a.length - 1;
        int mid;

        while (low <= high) {
            mid = (low + high) / 2;
            if (a[mid] < x) {
                low = mid + 1;
            } else if(a[mid] > x) {
                high = mid -1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    int binarySearch2(int [] a, int x, int low, int high) {
        if (low > high) return -1; // Error

        int mid = (low + high) / 2;
        if (a[mid] < x) {
            return binarySearch2(a, x, mid + 1, high);
        } else if (a[mid] > x) {
            return binarySearch2(a, x, low, mid - 1);
        } else {
            return mid;
        }
    }

    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();
        int [] arr = {1, 2, 3, 4, 5, 6};
        int i = binarySearch.binarySearch2(arr, 5, 0, arr.length);
        System.out.println("Index " + i);
    }
}
