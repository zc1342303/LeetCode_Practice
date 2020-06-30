package leetcode;

import java.util.*;

public class LRUCache {
    int capacity;
    Map<Integer, ListNode> map = new HashMap<>();
    ListNode head = new ListNode(-1, -1);
    ListNode tail = new ListNode(-1, -1);
    ListNode node;

    public static class ListNode {
        int key;
        int value;
        ListNode next = null;
        ListNode prev = null;
        ListNode node = null;
        ListNode(int x, int y) {key = x; value = y;}
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;

    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        // 由map获取node节点, 并把node节点放在最后
        node = map.get(key);
        node.prev.next = node.next;
        node.next.prev = node.prev;

        tail.prev.next = node;
        node.prev = tail.prev;
        tail.prev = node;
        node.next = tail;
        return node.value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            // 由map获取node节点，并把node节点放在最后
            node = map.get(key);
            node.prev.next = node.next;
            node.next.prev = node.prev;

            tail.prev.next = node;
            node.prev = tail.prev;
            tail.prev = node;
            node.next = tail;

            // 改node储存的值
            node.value = value;
            return ;
        }
        if (map.size() == capacity) {
            node = head.next;
            int del = node.key;

            // 删除node节点
            head.next = node.next;
            node.next.prev = head;

            // 在map里删除key
            map.remove(node.key);
        }

        node = new ListNode(key, value);

        tail.prev.next = node;
        node.prev = tail.prev;
        tail.prev = node;
        node.next = tail;
        map.put(key, node);
    }
}
