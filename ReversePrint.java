package leetcode;

import java.util.Stack;
import java.util.Arrays;

public class ReversePrint {
    public int[] reversePrint(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        int amt = 0;

        while (head != null) {
            stack.push(head.val);
            head = head.next;
            amt++;
        }

        int[] res = new int[amt];
        for (int i = 0; i < amt; i++) {
            res[i] = stack.pop();
        }

        return res;
    }

    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {val = x;}
    }

    public static void main(String[] args) {
        ReversePrint solution = new ReversePrint();
        int[] tmp = {1, 2, 3};
        ListNode head = new ListNode(-1);
        ListNode node = head;
        for (int value : tmp) {
            node.next = new ListNode(value);
            node = node.next;
        }

        int[] ans = solution.reversePrint(head.next);
        System.out.println(Arrays.toString(ans));
    }

}
