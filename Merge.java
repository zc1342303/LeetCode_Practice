package leetcode;

import java.util.Arrays;

public class Merge {
    public void merge(int[] A, int m, int[] B, int n) {
        int j = m + n - 1;
        n--;
        int i = m - 1;

        while (n >= 0) {
            if (i >= 0 && A[i] >= B[n]) {
                A[j] = A[i];
                i--;
            }
            else {
                A[j] = B[n];
                n--;
            }
            j--;
        }
    }
    public static void main(String[] args) {
        Merge solution = new Merge();
        int[] A = {0};
        int[] B = {1};
        int m = 0;
        int n = 1;

        solution.merge(A, m, B, n);
        System.out.println(Arrays.toString(A));
    }
}

