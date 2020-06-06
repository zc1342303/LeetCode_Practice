package practice;

public class ReverseBetween {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        int idx = 0;

        ListNode h = new ListNode(-1);
        h.next = head;
        ListNode node = h;
        ListNode prev = h;
        ListNode next = h.next;
        ListNode recordPrev = null, recordNext = null;


        while (node != null) {
            prev = node;
            node = next;
            next = node.next;
            idx++;

            if (idx > m && idx <= n) {
                node.next = prev;
            }
            else if (idx == m) {
                recordPrev = prev;
            }
            if (idx == n) {
                recordNext = recordPrev.next;
                recordPrev.next = node;
                recordNext.next = next;
                break;
            }
        }
        return h.next;
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {val = x;}
    }
}
