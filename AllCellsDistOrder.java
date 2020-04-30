package practice;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AllCellsDistOrder {
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        boolean[][] history = new boolean[R][C];
        int[][] res = new int[R * C][2];
        int[] d = {-1, 0, 1, 0, -1};
        Queue<List<Integer>> record = new LinkedList<>();
        int x, y, dx, dy, k;
        List<Integer> tmp;
        record.offer(Arrays.asList(r0, c0));

        k = 0;
        while (record.peek() != null) {
            tmp = record.poll();
            x = tmp.get(0);
            y = tmp.get(1);
            res[k][0] = x;
            res[k][1] = y;
            k++;
            for (int i = 0; i < 4; i++) {
                dx = d[i];
                dy = d[i + 1];
                if (x + dx >= 0 && x + dx < R && y + dy >= 0 && y + dy < C && !history[x + dx][y + dy]) {
                    record.offer(Arrays.asList(x + dx, y + dy));
                    history[x + dy][y + dy] = true;
                }
            }
        }
        return res;
    }
}


