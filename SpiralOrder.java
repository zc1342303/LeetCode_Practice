package leetcode;

public class SpiralOrder {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return new int[0];
        int top = 0, bottom = matrix.length - 1;
        int left = 0, right = matrix[0].length - 1;
        int[] res = new int[matrix[0].length * matrix.length];
        int idx = 0;

        while (left <= right && top <= bottom) {
            for (int i = left; i <= right; i++) {
                res[idx++] = matrix[top][i];
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                res[idx++] = matrix[i][right];
            }
            right--;
            if (left > right || top > bottom) break;

            for (int i = right; i >= left; i--) {
                res[idx++] = matrix[bottom][i];
            }
            bottom--;
            for (int i = bottom; i >= top; i--) {
                res[idx++] = matrix[i][left];
            }
            left++;
        }

        return res;
    }
}
