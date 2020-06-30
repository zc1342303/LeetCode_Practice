package leetcode;

public class Maximum {
    public int maximum(int a, int b) {
        int k = (int)(((long)a - b) >>> 63);
        return (k^1) * a + k * b;
    }

    public static void main(String[] args) {
        Maximum solution = new Maximum();
        int a = 2;
        int b = 1;
        int ans = solution.maximum(a, b);
        System.out.println(ans);
    }
}
