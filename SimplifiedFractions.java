package leetcode;

import java.util.*;

public class SimplifiedFractions {
    public List<String> simplifiedFractions(int n) {
        List<String> res = new ArrayList<>();
        for (int j = 2; j <= n; j++) {
            for (int i = 1; i < j; i++) {
                if (gcd(i, j)) {
                    res.add(Integer.toString(i) + '/' + j);
                }
            }
        }
        return res;
    }

    public boolean gcd(int i, int j) {
        int tmp;
        while (i != 0) {
            tmp = i;
            i = j % i;
            j = tmp;
        }
        return j == 1;
    }

    public static void main(String[] args) {
        SimplifiedFractions solution = new SimplifiedFractions();
        int n = 10;
        List<String> ans = solution.simplifiedFractions(n);
        System.out.println(ans);
    }




}
