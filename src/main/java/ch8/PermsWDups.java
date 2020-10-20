package ch8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class PermsWDups {

    ArrayList<String> printPerms(String s) {
        ArrayList<String> result = new ArrayList<>();
        HashMap<Character, Integer> map = buildFreqTable(s);
        System.out.println(map);
        printPerms(map, "", s.length(), result);
        return result;
    }

    private void printPerms(HashMap<Character, Integer> map, String prefix, int remaining, ArrayList<String> result) {
        // Base case permutation has been completed
        if (remaining == 0) {
            result.add(prefix);
            return;
        }

        // Try remaining letters for next char, and generate remaining permutations
        for (Character c: map.keySet()) {
            int count = map.get(c);
            if (count > 0) {
                map.put(c, count - 1);
                printPerms(map, prefix + c, remaining - 1, result);
                map.put(c, count);
            }
        }
    }

    private HashMap<Character, Integer> buildFreqTable(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c: s.toCharArray()) {
            if (!map.containsKey(c)) {
                map.put(c, 0);
            }
            map.put(c, map.get(c) + 1);
        }
        return map;
    }

    public static void main(String[] args) {
        PermsWDups permsWDups = new PermsWDups();
        ArrayList<String> aaabbcc = permsWDups.printPerms("aaabbcc");
        System.out.println(Arrays.toString(aaabbcc.toArray()));
    }

}
