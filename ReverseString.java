package practice;

public class ReverseString {
    public void reverseString(char[] s) {
        int n = s.length;
        for (int i = 0; i < n/2; i++) {
            char a = s[i];
            char b = s[n-i-1];
            s[i] = b;
            s[n-i-1] = a;
        }
    }
}
