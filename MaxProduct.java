package practice;

public class MaxProduct {
    public int maxProduct(int[] nums) {
        int negative = 0;
        int curr = 1;
        int res = Integer.MIN_VALUE;

        for (int num : nums) {
            if (num == 0) {
                res = Math.max(res, 0);
                negative = 0;
                curr = 1;
                continue;
            }
            curr *= num;
            if (curr < 0 && negative != 0) {
                res = Math.max(res, curr / negative);
            }
            if (negative == 0 && curr < 0) {
                negative = curr;
            }
            else if (curr > 0) {
                res = Math.max(res, curr);
            }
            if (res < 0 && num < 0) {
                res = Math.max(res, num);
            }
        }
        return res;

    }
    public static void main(String[] args) {
        MaxProduct solution = new MaxProduct();
        int[] nums = {2, 3, -2, 4};
        int ans = solution.maxProduct(nums);
        System.out.println(ans);
    }
}
