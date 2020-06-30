package leetcode;

public class Jump {
    public int jump(int[] nums) {
        int n = nums.length;
        int maxDistance = 0;
        int times = 0;
        int curr_max = 0;

        for (int i = 0; i < n - 1; i++) {
            curr_max = Math.max(curr_max, i + nums[i]);
            if (i == maxDistance) {
                times++;
                maxDistance = curr_max;
            }
        }
        return times;
    }

    public static void main (String[] args) {
        Jump solution = new Jump();
        int[] nums = {2, 3, 1, 1, 4};
        int ans = solution.jump(nums);
        System.out.println(ans);
    }
}
