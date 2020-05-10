package practice;

import java.util.*;

public class MinTime {
    Map<Integer, List<Integer>> tree = new HashMap<>();
    List<Boolean> hasApple;
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        this.hasApple = hasApple;
        for (int[] edge : edges) {
            if (this.tree.get(edge[0]) == null) {
                List<Integer> tmp = new ArrayList<>();
                tmp.add(edge[1]);
                this.tree.put(edge[0], tmp);
            } else {
                List<Integer> tmp = tree.get(edge[0]);
                this.tree.remove(edge[0]);
                tmp.add(edge[1]);
                this.tree.put(edge[0], tmp);
            }
        }

        int amt = dfs(0);

        return amt > 0 ? amt - 2 : 0;
    }
    public int dfs(int node) {
        if (this.tree.get(node) == null) {
            if (this.hasApple.get(node)) {
                return 2;
            }
            else {
                return 0;
            }
        }

        List<Integer> sons = this.tree.get(node);

        int amt = 0;
        for (int son: sons) {
            amt += dfs(son);
        }

        if (amt > 0) {
            return amt + 2;
        }
        else if (this.hasApple.get(node)) {
            return 2;
        }
        else {
            return 0;
        }
    }

    public static void main(String[] args) {
        MinTime solution = new MinTime();
        int n = 7;
        int[][] edges = {{0, 1}, {0, 2}, {1, 4}, {1, 5}, {2, 3}, {2, 6}};
        List<Boolean> hasApple = Arrays.asList(false, false, true, false, true, true, false);

        int ans = solution.minTime(n, edges, hasApple);
        System.out.println(ans);
    }
}
