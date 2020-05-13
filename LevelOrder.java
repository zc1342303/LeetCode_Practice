package practice;

import java.util.*;

public class LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        Queue<TreeNode> curr = new LinkedList<>();
        Queue<TreeNode> next = new LinkedList<>();
        if (root == null) {
            return res;
        }
        curr.offer(root);
        List<Integer> line = new LinkedList<>();

        while (curr.peek() != null) {
            TreeNode node = curr.poll();
            line.add(node.val);
            if (node.left != null) {
                next.add(node.left);
            }
            if (node.right != null) {
                next.add(node.right);
            }
            if (curr.peek() == null) {
                res.add(line);
                line = new LinkedList<>();
                curr = new LinkedList<>(next);
                next.clear();
            }
        }
        return res;
    }
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {val = x;}
    }

}
