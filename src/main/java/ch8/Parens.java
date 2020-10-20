package ch8;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Parens {

    Set<String> generateParens(int remaining) {
        Set<String> set = new HashSet<>();
        if (remaining == 0) {
            set.add("");
        } else {
            Set<String> prev = generateParens(remaining - 1);
            for (String str : prev) {
                for (int i = 0; i < str.length(); i++) {
                    if (str.charAt(i) == '(') {
                        String s = insertInside(str, i);
                        // Add s to set if it's not already in there. Note: HashSet automatically checks for duplicates
                        // before adding, so an explicit check is not necessary
                        set.add(s);
                    }
                }
                set.add("()" + str);
            }
        }
        return set;
    }

    String insertInside(String str, int leftIndex) {
        String left = str.substring(0, leftIndex + 1);
        String right = str.substring(leftIndex + 1, str.length());

        return left + "()" + right;
    }

    public static void main(String[] args) {
        Parens parens = new Parens();
        Set<String> strings = parens.generateParens(4);
        Iterator<String> iterator = strings.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            System.out.println(next);
        }
    }
}
