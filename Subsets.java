package leetcode;

import java.util.*;

public class Subsets {
    List<List<Integer>> res;
    public List<List<Integer>> subsets(int[] nums) {
        this.res = new LinkedList<>();
        List<Integer> ret = new LinkedList<>();
        int n = nums.length;
        dfs(ret, 0, nums, n);
        return res;
    }

    public void dfs(List<Integer> ret, int start, int[] nums, int n) {
        res.add(new LinkedList(ret));
        for (int i = start; i < n; i++) {
            LinkedList<Integer> tmpRet = new LinkedList(ret);
            tmpRet.add(nums[i]);
            dfs(tmpRet, i+1, nums, n);
        }
        return ;
    }
}
