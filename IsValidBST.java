package leetcode;

public class IsValidBST {
    int prev;
    boolean isValid = true;
    boolean first = true;
    public boolean isValidBST(TreeNode root) {
        dfs(root);
        return isValid;
    }
    public void dfs(TreeNode node) {
        if (node == null) {
            return ;
        }
        dfs(node.left);
        int curr = node.val;
        if (this.first) {
            this.first = false;
        }
        else if (this.prev >= curr) {
            this.isValid = false;

        }
        this.prev = curr;

        dfs(node.right);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {val = x;}
    }
}
