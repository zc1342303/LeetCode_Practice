package leetcode;

import java.util.*;

public class BuildArray {
    public List<String> buildArray(int[] target, int n) {
        List<String> res = new ArrayList<>();
        int ptr = 0;
        int m = target.length;

        for (int i = 1; i <= target[m-1]; i++) {
            if (i == target[ptr]) {
                res.add("Push");
                ptr++;
            }
            else {
                res.add("Push");
                res.add("Pop");
            }
        }
        return res;
    }

    public static void main(String[] args) {
        BuildArray solution = new BuildArray();
        int[] target = {1, 3};
        int n = 3;

        List<String> ans = solution.buildArray(target, n);
        System.out.println(ans.toString());
    }
}
