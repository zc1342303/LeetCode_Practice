package leetcode;

import java.util.*;

public class ArrangeWords {
    public String arangeWords(String text) {
        String[] s = text.toLowerCase().split(" ");
        Arrays.sort(s, (o1, o2) -> {return o1.length() - o2.length();});
        char first = s[0].charAt(0);
        String str = (char)(first - 32) + s[0].substring(1);
        s[0] = str;
        String res;
        res = String.join(" ", s);
        return res;
    }

    public static void main(String[] args) {
        ArrangeWords solution = new ArrangeWords();
        String text = "Leetcode is cool";
        String ans = solution.arangeWords(text);
        System.out.println(ans);
    }

}
