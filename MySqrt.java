package leetcode;

public class MySqrt {
    public int mySqrt(int x) {
        int l = 0;
        int r = x;
        int ans = -1;

        while (l < r) {
            int mid = l + (r - l) / 2;
            if ((long)mid * mid <= x) {
                ans = mid;
                l = mid + 1;
            }
            else {
                r = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int x = 4;
        MySqrt solution = new MySqrt();
        int ans = solution.mySqrt(x);
        System.out.println(ans);
    }
}
