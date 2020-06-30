package leetcode;

import java.util.*;

public class LargestRectangleArea {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        if (n == 0) return 0;
        if (n == 1) return heights[0];
        int[] newHeights = new int[n+1];
        for (int i = 0; i < n; i++) {
            newHeights[i] = heights[i];
        }

        Deque<Integer> stack = new LinkedList<>();
        int height, width, l, r;
        int area;
        int res = 0;

        for (r = 0; r < n+1; r++) {
            while (!stack.isEmpty() && newHeights[r] < newHeights[stack.peekLast()]) {
                height = newHeights[stack.removeLast()];
                if (stack.isEmpty()) {
                    l = -1;
                }
                else {
                    l = stack.peekLast();
                }
                width = r - l - 1;
                area = width * height;
                res = Math.max(res, area);
            }
            stack.addLast(r);
        }
        return res;
    }
}
