package practice;

import java.util.*;

public class FindLadders {
    private Map<String, Integer> wordId;
    private String[] idWord;
    private List<Integer>[] graph;
    private int len;
    private List<List<String>> res;
    private int[] visited;

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        wordList.add(beginWord);
        len = wordList.size();
        idWord = new String[len];
        wordId = new HashMap<>();
        visited = new int[len];
        for (int i = 0; i < len; i++) {visited[i] = Integer.MAX_VALUE;}
        graph = new LinkedList[len];
        for (int i = 0; i < len; i++) {graph[i] = new LinkedList<>();}
        res = new ArrayList<>();

        int i = 0;
        for (String word : wordList) {
            wordId.put(word, i);
            idWord[i] = word;
            i++;
        }

        // 特判不在字典中
        if (!wordId.containsKey(endWord)) return res;
        // 构造图的临接矩阵
        initGraph(idWord);
        int end = wordId.get(endWord);

        Queue<List<Integer>> q = new LinkedList<>();
        List<Integer> tmpBegin = new LinkedList<>();
        tmpBegin.add(wordId.get(beginWord));
        q.offer(tmpBegin);

        bfs(q, end);

        return res;
    }
    private void bfs(Queue<List<Integer>> q, int end) {
        // 广度优先搜索
        // System.out.println(q.peek().toString());
        while (!q.isEmpty()) {
            List<Integer> curr = q.poll();
            int last = curr.get(curr.size() - 1);
            if (last == end) {
                List<String> tmp = new LinkedList<>();
                for (int index : curr) {
                    tmp.add(idWord[index]);
                }
                res.add(tmp);
            }
            else {
                for (int i = 0; i < graph[last].size(); i++) {
                    int to = graph[last].get(i);
                    // 仅保留更近的路径, 或相等的路径
                    if (visited[last] + 1 <= visited[to]) {
                        visited[to] = visited[last] + 1;
                        List<Integer> tmp = new LinkedList<>(curr);
                        tmp.add(to);
                        q.add(tmp);
                    }
                }
            }
        }

    }

    private void initGraph(String[] idWord) {
        int i, j;
        for (i = 0; i < len; i++) {
            for (j = i + 1; j < len; j++) {
                if (differences(idWord[i], idWord[j]) == 1) {
                    graph[i].add(j);
                    graph[j].add(i);
                }
            }
        }
    }

    private int differences(String word1, String word2) {
        int n = word1.length();
        int dif = 0;
        for (int i = 0; i < n; i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                dif++;
            }
        }
        return dif;
    }
}
