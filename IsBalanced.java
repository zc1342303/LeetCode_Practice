package practice;

public class IsBalanced {
    boolean check;
    public boolean isBalanced(TreeNode root) {
        this.check = true;
        dfs(root);
        return this.check;
    }
    public int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftHight = dfs(node.left);
        int rightHight = dfs(node.right);

        if (Math.abs(leftHight - rightHight) > 1) {
            this.check = false;
        }

        return Math.max(leftHight, rightHight) + 1;
    }
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode (int x) {val = x;}
    }
}
