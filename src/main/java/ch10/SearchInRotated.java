package ch10;

public class SearchInRotated {

    int search(int a[], int left, int right, int x) {
        int mid = (left + right) / 2;
        if (x == a[mid]) { // found element
            return mid;
        }

        if (right < left) {
            return -1;
        }

        // Either the left or right half must be normally ordered
        // Find out which side is normally ordered, and then use the normally ordered half to figure out which
        // side to search to find x
        if (a[left] < a[mid]) { // Left is normally ordered
            if (x >= a[left] && x < a[mid]) {
                return search(a, left, mid - 1, x); // search left
            } else {
                return search(a, mid + 1, right, x); // search right
            }
        } else if (a[mid] < a[left]) { // Right is normally ordered
            if (x > a[mid] && x <= a[right]) {
                return search(a, mid + 1, right, x); // search right
            } else {
                return search(a, left, mid - 1, x); // search left
            }
        } else if (a[left] == a[mid]) { // left or right half is all repeats
            if (a[mid] != a[right]) { // if right is different search it
                return search(a, mid + 1, right, x); // serach right
            } else { // else we have to search both halves
                int result = search(a, left, mid - 1, x); // search left
                if (result == -1) {
                    return search(a, mid + 1, right, x); // search right
                } else {
                    return result;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        SearchInRotated searchInRotated = new SearchInRotated();

        int [] test = {15, 16, 19, 20, 25, 1, 3, 4, 5,7, 10, 14};
        int search = searchInRotated.search(test, 0, test.length, 4);
        System.out.println("Res " + search);
    }
}
