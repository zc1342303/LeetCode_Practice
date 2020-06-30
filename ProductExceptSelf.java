package leetcode;

public class ProductExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int factor = 1;

        for (int i = 0; i < n; i++) {
            res[i] = factor;
            factor *= nums[i];
        }

        factor = 1;
        for (int i = n-1; i >= 0; i--) {
            res[i] *= factor;
            factor *= nums[i];
        }
        return res;
    }
}
