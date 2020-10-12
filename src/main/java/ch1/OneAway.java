package ch1;

public class OneAway {

    boolean oneEditAway(String first, String second) {
        if (first.length() == second.length()) {
            return oneEditReplace(first, second);
        } else if(first.length() + 1 == second.length()) {
            return oneEditInsert(first, second);
        } else if(first.length() - 1 == second.length()) {
            return oneEditInsert(second, first);
        }
        return false;
    }


    boolean oneEditReplace(String s, String t) {
        boolean foundDifference = false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != t.charAt(i)) {
                if (foundDifference) {
                    return false;
                }
                foundDifference = true;
            }
        }
        return true;
    }

    /**
     * Check if you can insert a character into s to make t
     * @param s
     * @param t
     * @return
     */
    boolean oneEditInsert(String s, String t) {
        int index1 = 0;
        int index2 = 0;
        while (index2 < t.length() && index1 < s.length()) {
            if (s.charAt(index1) != t.charAt(index2)) {
                if (index1 != index2) {
                    return false;
                }
                index2++;
            } else {
                index1++;
                index2++;
            }
        }
        return true;
    }

    boolean oneEditAway2(String first, String second) {
        if (Math.abs(first.length() - second.length()) > 1) {
            return false;
        }

        // Get shorter and longer string
        String s1 = first.length() < second.length() ? first : second;
        String s2 = first.length() < second.length() ? second : first;

        int index1 = 0;
        int index2 = 0;
        boolean foundDifference = false;
        while (index2 < s2.length() && index1 < s1.length()) {
            if (s1.charAt(index1) != s2.charAt(index2)) {
                // Ensure that this is the first difference found
                if (foundDifference) return false;
                foundDifference = true;

                if (s1.length() == s2.length()) {
                    index1++;
                }
            } else {
                index1++;
            }
            index2++;
        }
        return true;
    }

    public static void main(String[] args) {
        OneAway oneAway = new OneAway();
        System.out.println(oneAway.oneEditAway2("apple", "aple"));

    }
}
