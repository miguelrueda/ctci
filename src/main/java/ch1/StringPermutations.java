package ch1;

import java.util.Arrays;

public class StringPermutations {

    public String sort(String s) {
        char [] content = s.toCharArray();
        Arrays.sort(content);
        return new String(content);
    }

    boolean permutation(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        return sort(s).equals(sort(t));
    }

    boolean permutation2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int [] letters = new int[128];
        char[] s_array = s.toCharArray();
        for (char c: s_array) {
            letters[c]++;
        }

        System.out.println(Arrays.toString(letters));

        for (int i = 0; i < t.length(); i++) {
            int c = (int) t.charAt(i);
            letters[c]--;
            if (letters[c] < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        StringPermutations stringPermutations = new StringPermutations();
        String testString = "Hello world!";
        System.out.println(stringPermutations.sort(testString));
        String testString2 = "world! Hello";
        System.out.println(stringPermutations.sort(testString2));

        System.out.println(stringPermutations.permutation2(testString, testString2));
    }
}
