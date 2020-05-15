package practice;

public class ReverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode res = new ListNode(-1);
        res.next = head;

        ListNode prev = null, next, newTail = null;
        ListNode sTail = res;
        ListNode node = res;

        while (true) {
            // 检查剩余长度是否为n的整数倍
            ListNode tmp = node;
            for (int j = 0; j < k; j++) {
                tmp = tmp.next;
                if (tmp == null) {
                    return res.next;
                }
            }
            node = node.next;
            sTail.next = tmp;
            for (int i = 0; i < k; i++) {
                if (i == 0) {
                    newTail = node;
                    prev = node;
                    node = node.next;
                    continue;
                }
                next = node.next;
                node.next = prev;
                prev = node;
                node = next;
            }
            assert newTail != null;
            newTail.next = node;
            node = newTail;
            sTail = node;
        }
    }

    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {val = x;}
    }
}
