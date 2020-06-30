package leetcode;

public class FindLUSlength {
    public int findLUSlength(String a, String b) {
        if (a.equals(b)) {
            return -1;
        }
        return Math.max(a.length(), b.length());
    }
    public static void main(String[] args) {
        String a = "abc";
        String b = "cdc";

        FindLUSlength solution = new FindLUSlength();
        int ans = solution.findLUSlength(a, b);
        String out = String.valueOf(ans);
        System.out.println(out);
    }
}
