package practice;

import java.util.*;

public class DailyTemperatures {
    public int[] dailyTemperatures(int[] T) {
        int n = T.length;
        int[] res = new int[n];

        LinkedList<Integer> stack = new LinkedList<>();

        // d : day;
        for (int d = n-1; d >= 0; d--) {
            while (!stack.isEmpty() && T[d] >= T[stack.peekLast()]) {
                stack.pollLast();
            }
            if (stack.isEmpty()) {
                res[d] = 0;
            }
            else {
                res[d] = stack.peekLast() - d;
            }
            stack.offerLast(d);
        }

        return res;
    }
}
