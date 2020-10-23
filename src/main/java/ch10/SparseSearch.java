package ch10;

public class SparseSearch {

    int search(String [] strings, String str, int first, int last) {
        if (first > last) return -1;
        //  Move mid to the middle
        int mid = (first + last) / 2;

        // If mid is empty find closest non empty string
        if (strings[mid].isEmpty()) {
            int left = mid - 1;
            int right = mid + 1;
            while (true) {
                if (left < first && right > last) {
                    return -1;
                } else if (right <= last && !strings[right].isEmpty()) {
                    mid = right;
                    break;
                } else if (left >= first && !strings[left].isEmpty()) {
                    mid = left;
                    break;
                }
                right++;
                left--;
            }
        }

        // Check for string, and recurse if necessary
        if (str.equals(strings[mid])) { // Found it
            return mid;
        } else if (strings[mid].compareTo(str) < 0) { // search right
            return search(strings, str, mid + 1, last);
        } else {
            return search(strings, str, first, mid - 1);
        }
    }

    int search(String [] strings, String str) {
        if (strings == null || str == null || str == "") {
            return -1;
        }
        return search(strings, str, 0, strings.length - 1);
    }

    public static void main(String[] args) {
        String [] strings = {
                "at",
                "",
                "",
                "",
                "ball",
                "",
                "",
                "car",
                "",
                "",
                "dad",
                "",
                ""
        };
        SparseSearch sparseSearch = new SparseSearch();
        int ball = sparseSearch.search(strings, "ball");
        System.out.println(ball);
    }
}
