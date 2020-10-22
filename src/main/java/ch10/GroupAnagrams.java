package ch10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

class AnagramComparator implements Comparator<String> {

    public String sortChars(String s) {
        char [] content = s.toCharArray();
        Arrays.sort(content);
        return new String(content);
    }

    @Override
    public int compare(String o1, String o2) {
        return sortChars(o1).compareTo(o2);
    }
}

public class GroupAnagrams {

    public void sort(String [] array) {
        HashMapList<String, String> mapList = new HashMapList<>();

        // Group words by anagram
        for (String s : array) {
            String key = sortChars(s);
            mapList.put(key, s);
        }

        // Convert hash table to array
        int index = 0;
        for(String key: mapList.keySet()) {
            ArrayList<String> list = mapList.get(key);
            for (String t : list) {
                array[index] = t;
                index++;
            }
        }
    }

    public String sortChars(String s) {
        char [] content = s.toCharArray();
        Arrays.sort(content);
        return new String(content);
    }

    public static void main(String[] args) {
        String [] test = new String[10];
        test[0] = "Hi";
        test[1] = "its";
        test[2] = "Hello";
        test[3] = "elloH";
        test[4] = "little";
        test[5] = "acre";
        test[6] = "twin";
        test[7] = "care";
        test[8] = "race";
        test[9] = "me";

//        Arrays.sort(test, new AnagramComparator());

        GroupAnagrams groupAnagrams = new GroupAnagrams();
        groupAnagrams.sort(test);
        System.out.println(Arrays.toString(test));
    }
}
