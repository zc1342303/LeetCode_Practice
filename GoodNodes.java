package leetcode;

public class GoodNodes {
    int res = 0;
    public int goodNodes(TreeNode root) {
        int m = Integer.MIN_VALUE;
        dfs(root, m);

        return res;
    }

    public void dfs(TreeNode node, int maxPoint) {
        if (node == null) {
            return ;
        }

        if (node.val >= maxPoint) {
            res++;
            maxPoint = node.val;
        }

        dfs(node.left, maxPoint);
        dfs(node.right, maxPoint);
    }


    private static class TreeNode {
        int val;
        TreeNode left = null;
        TreeNode right = null;
        TreeNode(int x) {val = x;}
    }
}
