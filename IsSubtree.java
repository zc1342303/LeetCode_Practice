package leetcode;

public class IsSubtree {
    public boolean isSubtree(TreeNode s, TreeNode t) {

        return findRoot(s, t);
    }
    public boolean findRoot(TreeNode s, TreeNode t) {
        if (s == null) {
            return false;
        }

        if (s.val == t.val) {
            if (dfs(s, t)) {
                return true;
            }
        }

        return findRoot(s.left, t) || findRoot(s.right, t);
    }

    public boolean dfs(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        else if (s == null || t == null) {
            return false;
        }

        if (s.val != t.val) {
            return false;
        }

        return dfs(s.left, t.left) && dfs(s.right, t.right);
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x;}
    }
}
