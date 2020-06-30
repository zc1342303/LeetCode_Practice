package leetcode;

public class MaxPower {
    public int maxPower(String s) {
        int res = 1;
        int amt = 1;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i-1) != s.charAt(i)) {
                res = Math.max(res, amt);
                amt = 1;
            }
            else {
                amt++;
            }
        }
        res = Math.max(res, amt);
        return res;
    }

    public static void main(String[] args) {
        MaxPower solution = new MaxPower();
        String s = "leetcode";
        int ans = solution.maxPower(s);
        System.out.println(ans);
    }

}
