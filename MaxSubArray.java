package practice;

public class MaxSubArray {
    Status pushUp(Status l, Status r) {
        int iSum = l.iSum + r.iSum;
        int lSum = Math.max(l.lSum, l.iSum + r.lSum);
        int rSum = Math.max(r.rSum, r.iSum + l.rSum);
        int mSum = Math.max(Math.max(l.mSum, r.mSum), l.rSum + r.lSum);
        return new Status(lSum, rSum, mSum, iSum);
    }

    Status get(int[] a, int l, int r) {
        if (l == r) return new Status(a[l], a[l], a[l], a[l]);
        int m = (l + r) >> 1;
        Status lSub = get(a, l, m);
        Status rSub = get(a, m + 1, r);
        return pushUp(lSub, rSub);
    }

    public int maxSubArray(int[] nums) {
        Status res = get(nums, 0, nums.length-1);
        return res.mSum;
    }

    private static class Status {
        int lSum;
        int rSum;
        int mSum;
        int iSum;
        Status(int i, int j, int m, int n) {lSum = i; rSum = j; mSum = m; iSum = n;}
    }

    public static void main(String[] args) {
        MaxSubArray solution = new MaxSubArray();
        int[] nums = {-2, 1, -3, -4, -1, 2, 1, -5, 4};
        int ans = solution.maxSubArray(nums);
        System.out.println(ans);
    }
}
