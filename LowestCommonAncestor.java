package practice;

public class LowestCommonAncestor {
    TreeNode p;
    TreeNode q;
    TreeNode res;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.p = p;
        this.q = q;

        dfs(root);

        return this.res;
    }

    public int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left = dfs(node.left);
        int right = dfs(node.right);
        int ret = left + right;
        if (node == p || node == q) {
            ret++;
        }
        if (ret == 2) {
            this.res = node;
        }
        return ret != 2 ? ret : 1;
    }


    private static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {val = x;}
    }
}
