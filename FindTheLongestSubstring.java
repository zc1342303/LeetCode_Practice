package leetcode;

public class FindTheLongestSubstring {
    public int findTheLongestSubstring(String s) {
        int[] odd = new int[32];
        for (int i = 0; i < 32; i++) odd[i] = -1;
        int n = s.length();
        int res = 0;

        // 位运算, 用5位分别记录5个元音, 分别是a, e, i, o, u
        // 如果是奇数该位记录位1, 如果是偶数, 该位记录位0
        int curr = 0;  // 记录当前字符串元音字母的奇偶性, 表示当前的状态
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);

            if (c == 'a') curr ^= 1 << 0;
            else if (c == 'e') curr ^= 1 << 1;
            else if (c == 'i') curr ^= 1 << 2;
            else if (c == 'o') curr ^= 1 << 3;
            else if (c == 'u') curr ^= 1 << 4;

            // 如果没有记录过当前奇偶性状态, 即初值为-1，则记录
            // 如果记录过, 那么当前的减去之前记录的索引, 得出的中间字符串所有元音都出现过偶数次
            if (curr == 0) res = Math.max(res, i+1);
            else if (odd[curr] == -1) odd[curr] = i;
            else res = Math.max(res, i - odd[curr]);
        }
        return res;
    }
}
