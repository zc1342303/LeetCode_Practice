package leetcode;

public class SortArrayByParity {
    public int[] sortArrayByParity(int[] A) {
        int slow = 0, fast, tmp;
        for (fast = 0; fast < A.length; fast++) {
            if (A[fast] % 2 == 0){
                tmp = A[fast];
                A[fast] = A[slow];
                A[slow] = tmp;
                slow++;
            }
        }

        return A;
    }
}
