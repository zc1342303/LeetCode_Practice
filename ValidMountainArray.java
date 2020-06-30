package leetcode;

public class ValidMountainArray {
    public boolean validMountainArray(int[] A) {
        int l = 0;
        int n = A.length;
        int r = n - 1;

        while (l < n-1 && A[l] < A[l+1]) l++;
        while (r >= 1 && A[r] < A[r-1]) r--;

        return l >= r && l > 0 && r < n-1;
    }
}
