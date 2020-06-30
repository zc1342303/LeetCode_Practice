package leetcode;

import java.util.*;

public class InorderMap {
    HashMap<Integer, Integer> inorderMap = new HashMap<>();
    int[] preorder;
    int[] inorder;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        if (n == 0) return null;
        this.preorder = preorder;
        this.inorder = inorder;

        // initialize inorderMap
        for (int i = 0; i < n; i++) {
            inorderMap.put(inorder[i], i);
        }

        TreeNode root = createTree(0, 0, n-1);
        return root;
    }

    public TreeNode createTree(int rootLoc, int l, int r) {
        if (l > r) {
            return null;
        }
        int preVal = preorder[rootLoc];
        TreeNode root = new TreeNode(preVal);
        int mid = inorderMap.get(preVal);

        int leftLen = mid - l;
        TreeNode left = createTree(rootLoc+1, l, mid-l);
        TreeNode right = createTree(rootLoc + leftLen + 1, mid + 1, r);

        root.left = left;
        root.right = right;

        return root;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode (int x) {val = x;}
    }
}
