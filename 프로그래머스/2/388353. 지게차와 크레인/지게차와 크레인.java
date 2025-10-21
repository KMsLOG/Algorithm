import java.util.*;

class Solution {
    static int[][] map;
    static int N, M, answer;
    static int[] dr = {0, 0, -1, 1};
    static int[] dc = {1, -1, 0, 0};
    static Map<Character, Integer> charMap;

    public int solution(String[] storage, String[] requests) {
        N = storage.length;
        M = storage[0].length();
        answer = N * M;
        charMap = new HashMap<>();

        map = new int[N + 2][M + 2];

        int idx = 1;

        for (String s : storage) {
            for (int i = 0; i < M; i++) {
                char c = s.charAt(i);
                if (!charMap.containsKey(c)) {
                    charMap.put(c, idx++);
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            String s = storage[i - 1];
            for (int j = 1; j <= M; j++) {
                char c = s.charAt(j - 1);
                map[i][j] = charMap.get(c);
            }
        }

        for (String req : requests) {
            List<int[]> updateNode = new ArrayList<>();
            if (req.length() > 1) {
                craine(req, updateNode);
            } else {
                car(req, updateNode);
            }

            answer -= updateNode.size();
            for (int[] node : updateNode) {
                map[node[0]][node[1]] = 0;
            }
        }

        return answer;
    }

    static List<int[]> car(String alpa, List<int[]> updateNode) {
        int target = charMap.getOrDefault(alpa.charAt(0), -1);
        if (target == -1) return updateNode;

        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[N + 2][M + 2];

        q.offer(new int[]{0, 0});
        visited[0][0] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                if (nr < 0 || nr >= N + 2 || nc < 0 || nc >= M + 2) continue;
                if (visited[nr][nc]) continue;

                if (map[nr][nc] == 0) {
                    visited[nr][nc] = true;
                    q.offer(new int[]{nr, nc});
                } else if (map[nr][nc] == target) {
                    visited[nr][nc] = true;
                    updateNode.add(new int[]{nr, nc});
                }
            }
        }
        return updateNode;
    }

    static List<int[]> craine(String alpa, List<int[]> updateNode) {
        int target = charMap.getOrDefault(alpa.charAt(0), -1);
        if (target == -1) return updateNode;

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (map[i][j] == target) {
                    updateNode.add(new int[]{i, j});
                }
            }
        }
        return updateNode;
    }
}
