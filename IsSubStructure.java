package leetcode;

public class IsSubStructure {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (B == null) return false;
        if (A == null) return false;
        return findSameRoot(A, B);
    }

    public boolean findSameRoot(TreeNode node1, TreeNode node2) {
        if (node1 == null) {
            return false;
        }

        if (node1.val == node2.val) {
            boolean isSame = isSameTree(node1, node2);
            if (isSame) {
                return true;
            }
        }

        return findSameRoot(node1.left, node2) || findSameRoot(node1.right, node2);
    }

    public boolean isSameTree(TreeNode node1, TreeNode node2) {
        if (node2 == null) {
            return true;
        }
        else if(node1 == null) {
            return false;
        }

        if (node1.val == node2.val) {

            return isSameTree(node1.left, node2.left) && isSameTree(node1.right, node2.right);
        }

        return false;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {val = x;}
    }

}
