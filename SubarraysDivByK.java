package leetcode;

public class SubarraysDivByK {
    public int subarraysDivByK(int[] A, int K) {
        int res = 0;
        int sum = 0;
        int[] amt = new int[K];
        amt[0] = 1;
        for (int num : A) {
            sum = (sum + num) % K;
            sum = (sum + K) % K;
            res += amt[sum];
            amt[sum]++;
        }
        return res;
    }
}
