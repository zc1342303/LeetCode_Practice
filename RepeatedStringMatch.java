package leetcode;

public class RepeatedStringMatch {
    public int repeatedStringMatch(String A, String B) {
        StringBuilder str = new StringBuilder(B);
        while (str.length() < 2 * A.length() + 2 * B.length()) {
            str.append(A);
        }
        int i;
        int times = 0;
        char[] s = str.toString().toCharArray();
        // System.out.println(Arrays.toString(s));
        int[] next = new int[s.length];
        next[0] = -1;
        for (i = 1; i < s.length; i++) {
            int j = next[i-1];
            while (j != -1 && s[i] != s[j+1]) {
                j = next[j];
            }
            if (s[i] == s[j+1]) {
                j++;
            }
            next[i] = j;
            // System.out.print(j);
            if (i - B.length() + 1 >= B.length() && j >= B.length()-1) {
                break;
            }
        }
        // 没有找到
        if (i == s.length) return -1;
        // 找到了
        int n = i - B.length();
        int res = n / A.length() + 1;
        return res;
    }
}
