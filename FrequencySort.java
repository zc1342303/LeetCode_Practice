package leetcode;

import java.util.*;

public class FrequencySort {
    public String frequencySort(String s) {
        int n = s.length();

        Map<Character, Integer> counter = new HashMap<>();

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (!counter.containsKey(c)) {
                counter.put(c, 1);
            }
            else {
                int amt = counter.get(c);
                counter.put(c, amt+1);
            }
        }
        Comparator<Node> cmp = (node1, node2) -> node2.amt - node1.amt;
        PriorityQueue<Node> pq = new PriorityQueue<>(cmp);

        for (char c : counter.keySet()) {
            Node node = new Node(c, counter.get(c));
            pq.offer(node);
        }

        StringBuilder res = new StringBuilder();
        while (!pq.isEmpty()) {
            Node node = pq.peek();
            res.append(String.valueOf(node.c).repeat(Math.max(0, node.amt)));
            pq.poll();
        }
        return res.toString();
    }


    static class Node {
        char c;
        int amt;
        Node (char c, int amt) {this.c = c; this.amt = amt;}
    }

    public static void main(String[] args) {
        String ip = "tree";
        FrequencySort solution = new FrequencySort();
        String res = solution.frequencySort(ip);
        System.out.println(res);
    }
}

