package ch8;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class PowerSet {

    ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> set, int index) {
        ArrayList<ArrayList<Integer>> allSubsets;
        // Base case add empty set
        if (set.size() == index) {
            allSubsets = new ArrayList<>();
            allSubsets.add(new ArrayList<>());
        } else {
            allSubsets = getSubsets(set, index + 1);
            int item = set.get(index);
            System.out.println("Item: " + item + ", Index: " + index);
            ArrayList<ArrayList<Integer>> moreSubsets = new ArrayList<>();
            System.out.println(Arrays.toString(allSubsets.toArray()));
            for(ArrayList<Integer> subset : allSubsets) {
                ArrayList<Integer> newSubset = new ArrayList<>();
                newSubset.addAll(subset);
                newSubset.add(item);
                moreSubsets.add(newSubset);
            }
            allSubsets.addAll(moreSubsets);
        }
        return allSubsets;
    }

    ArrayList<ArrayList<Integer>> getSubsets2(ArrayList<Integer> set) {
        ArrayList<ArrayList<Integer>> allsubsets = new ArrayList<>();
        int max = 1 << set.size();
        System.out.println("Max " + max);
        System.out.println("Max " + Integer.toBinaryString(max));
        for (int k = 0; k < max; k++) {
            ArrayList<Integer> subset = convertIntToSet(k, set);
            System.out.println("From " + k + " got subset: " + Arrays.toString(subset.toArray()));
            allsubsets.add(subset);
        }
        return allsubsets;
    }

    private ArrayList<Integer> convertIntToSet(int x, ArrayList<Integer> set) {
        ArrayList<Integer> subset = new ArrayList<>();
        int index = 0;
        System.out.println("X: " + x);
        for (int k = x; k > 0; k >>= 1) {
            System.out.println("K is: " + k);

            System.out.println("binary k is: " + Integer.toBinaryString(k));
            System.out.println("binary k >> 1 is " + Integer.toBinaryString(k >> 1));
            if ((k & 1) == 1) {
                System.out.println("Adding " + set.get(index));
                subset.add(set.get(index));
            }
            index++;
        }
        return subset;
    }

    public static void main(String[] args) {
        PowerSet powerSet = new PowerSet();
        ArrayList<Integer> test = new ArrayList<>();
        test.add(1);
        test.add(2);
        test.add(3);
        test.add(4);
        ArrayList<ArrayList<Integer>> subsets = powerSet.getSubsets2(test);

        for(ArrayList<Integer> subset : subsets) {
            System.out.println(Arrays.toString(subset.toArray()));
        }
    }
}
