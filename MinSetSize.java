package leetcode;

import java.util.*;

public class MinSetSize {
    public int minSetSize(int[] arr) {
        Map<Integer, Integer> counter = new HashMap<>();
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            if (!counter.containsKey(arr[i])) {
                counter.put(arr[i], 1);
            }
            else {
                int amt = counter.get(arr[i]);
                counter.put(arr[i], amt + 1);
            }
        }
        List<Integer> amts = new LinkedList<>();
        for (int value : counter.values()) {
            amts.add(value);
        }
        Collections.sort(amts);

        int half = 0;
        int res = 0;
        while (half < n / 2) {
            half += amts.remove(amts.size()-1);
            res++;
        }

        return res;
    }
}
