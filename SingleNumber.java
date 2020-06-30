package leetcode;

public class SingleNumber {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int num: nums) {
            res ^= num;
        }
        return res;
    }
    public static void main(String[] args) {
        SingleNumber solution = new SingleNumber();
        int[] nums = {2, 2, 1};
        int ans = solution.singleNumber(nums);
        System.out.println(ans);
    }
}
