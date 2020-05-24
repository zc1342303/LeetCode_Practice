package practice;

import java.util.*;

public class PseudoPalindromicPaths {
    int res = 0;
    Set<Integer> valid = new HashSet<>();
    public int pseudoPalindromicPaths (TreeNode root) {
        valid.add(0);
        for (int i = 0; i < 9; i++) {
            valid.add(1 << i);
        }

        dfs(root, 0);
        return res;
    }

    public void dfs(TreeNode node, int status) {
        if (node == null) {
            return ;
        }

        int val = node.val;
        status ^= 1 << (val - 1);

        if (node.left == null && node.right == null) {
            if (valid.contains(status)) {
                res++;
            }
        }

        dfs(node.left, status);
        dfs(node.right, status);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
