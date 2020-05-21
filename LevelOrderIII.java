package practice;

import java.util.*;

public class LevelOrderIII {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> layerQueue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();

        nodeQueue.add(root);
        layerQueue.add(0);

        TreeNode node = null;
        int layer;
        int prevLayer = 0;
        LinkedList<Integer> row = new LinkedList<>();
        while (nodeQueue.peek() != null) {
            node = nodeQueue.poll();
            layer = layerQueue.poll();
            if (layer > prevLayer) {
                res.add(row);
                row = new LinkedList<>();
            }

            if (layer % 2 == 0) {
                row.addLast(node.val);
            }
            else {
                row.addFirst(node.val);
            }

            if (node.left != null) {
                nodeQueue.offer(node.left);
                layerQueue.offer(layer+1);
            }

            if (node.right != null) {
                nodeQueue.offer(node.right);
                layerQueue.offer(layer+1);
            }
            prevLayer = layer;
        }
        res.add(row);
        return res;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {val = x;}
    }
}
