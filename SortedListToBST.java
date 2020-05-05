package practice;

import java.util.ArrayList;
import java.util.List;

public class SortedListToBST {
    List<Integer> res = new ArrayList<>();
    public TreeNode sortedListToBST(ListNode head) {
        while (head != null) {
            this.res.add(head.val);
            head = head.next;
        }

        int l = 0;
        int r = this.res.size() - 1;
        TreeNode root = new TreeNode(-1);
        createTree(root, l, r, true);

        return root.left;
    }

    public void createTree(TreeNode root, int l, int r, boolean leftSon) {
        if (l > r) {
            return ;
        }
        int mid = l + (r - l) / 2;
        if (leftSon) {
            root.left = new TreeNode(this.res.get(mid));
            root = root.left;
        }
        else {
            root.right = new TreeNode(this.res.get(mid));
            root = root.right;
        }

        createTree(root, l, mid - 1, true);
        createTree(root, mid + 1, r, false);
    }

    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {val = x;}
    }
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {val = x;}
    }
    public static void main(String[] args) {
        SortedListToBST solution = new SortedListToBST();
        int[] tmp = {-10, -3, 0, 5, 9};
        ListNode head = new ListNode(-1);
        ListNode node = head;
        for (int value: tmp) {
            node.next = new ListNode(value);
            node = node.next;
        }

        TreeNode ans = solution.sortedListToBST(head.next);

    }
}
