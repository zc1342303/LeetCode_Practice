package practice;

import java.util.*;

public class FindOrder {
    List<List<Integer>> edges;
    int[] visited;
    List<Integer> result = new ArrayList<>();
    boolean invalid;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        edges = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }
        visited = new int[numCourses];
        List<Integer> tmp;
        for (int[] edge : prerequisites) {
            tmp = new ArrayList<>(edges.get(edge[1]));
            tmp.add(edge[0]);
            edges.set(edge[1], tmp);
        }

        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 0) {
                dfs(i);
            }
        }

        if (invalid) {
            return new int[0];
        }

        int[] res = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            res[i] = result.get(numCourses - i - 1);
        }
        return res;
    }

    public void dfs(int u) {
        visited[u] = 1;
        for (int v : edges.get(u)) {
            if (visited[v] == 0) {
                dfs(v);
                if (invalid) {
                    return ;
                }
            }
            else if (visited[v] == 1) {
                invalid = true;
                return ;
            }
        }
        visited[u] = 2;
        result.add(u);
    }

    public static void main(String[] args) {
        FindOrder solution = new FindOrder();
        int numCourses = 4;
        int[][] prerequisites = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        int[] ans = solution.findOrder(numCourses, prerequisites);
        System.out.println(Arrays.toString(ans));
    }

}
