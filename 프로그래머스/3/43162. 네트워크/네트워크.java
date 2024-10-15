import java.util.*;

class Solution {
    static boolean[] visited;

    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                bfs(i, computers);
                answer++;
            }
        }
        return answer;
    }

    static void bfs(int start, int[][] computers) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(start);
        visited[start] = true; // 시작 노드를 방문 처리

        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int num = 0; num < computers[cur].length; num++) { // 인덱스를 사용하여 접근
                if (computers[cur][num] == 1 && !visited[num]) {
                    q.add(num);
                    visited[num] = true; // 노드를 방문 처리
                }
            }
        }
    }
}
