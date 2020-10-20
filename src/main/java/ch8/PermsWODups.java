package ch8;

import java.util.ArrayList;
import java.util.Arrays;

public class PermsWODups {

    ArrayList<String> getPerms(String str) {
        System.out.println("Getting perms for " + str);
        if (str == null) return null;

        ArrayList<String> permutations = new ArrayList<>();
        if (str.length() == 0) { // base
            permutations.add("");
            return permutations;
        }

        char first = str.charAt(0); // Get the first char
        String remainder = str.substring(1);
        ArrayList<String> words = getPerms(remainder);
        for (String word: words) {
            for (int j = 0; j <= word.length(); j++) {
                String s = insertCharAt(word, first, j);
                permutations.add(s);
            }
        }
        return permutations;
    }

    // Insert char c at index i in word
    private String insertCharAt(String word, char c, int i) {
        String start = word.substring(0, i);
        String end = word.substring(i);
        return start + c + end;
    }

    ArrayList<String> getPerms2(String remaninder) {
        int len = remaninder.length();
        ArrayList<String> result = new ArrayList<>();

        // Base case
        if (len == 0) {
            result.add("");
            return result;
        }

        for (int i = 0; i < len; i++) {
            // Remove char i and find permutations of remaining chars
            String before = remaninder.substring(0, i);
            String after = remaninder.substring(i + 1, len);
            System.out.println("Before " + before);
            System.out.println("After " + after);
            ArrayList<String> partials = getPerms(before + after);


            System.out.println("Partials " + Arrays.toString(partials.toArray()));
            // Prepend char i to each permutation
            for (String s: partials) {
                result.add(remaninder.charAt(i) + s);
            }
        }
        return result;
    }

    ArrayList<String> getPerms3(String str) {
        ArrayList<String> result = new ArrayList<>();
        getPerms3("", str, result);
        return result;
    }

    void getPerms3(String prefix, String remainder, ArrayList<String> result) {
        if (remainder.length() == 0) result.add(prefix);

        int len = remainder.length();
        for (int i = 0; i < len; i++) {
            String before = remainder.substring(0, i);
            String after = remainder.substring(i + 1, len);
            char c = remainder.charAt(i);
            getPerms3(prefix + c, before + after, result);
        }
    }

    public static void main(String[] args) {
        PermsWODups permsWODups = new PermsWODups();
        ArrayList<String> abcd = permsWODups.getPerms3("abcd");
        System.out.println(Arrays.toString(abcd.toArray()));
    }

}
