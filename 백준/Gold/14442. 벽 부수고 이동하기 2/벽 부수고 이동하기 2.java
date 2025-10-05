import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    static int N, M, K;
    static int[][] map;
    static boolean[][][] visited;
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};

    static class Node {
        int r, c, broken, dist;
        Node(int r, int c, int broken, int dist) {
            this.r = r;
            this.c = c;
            this.broken = broken;
            this.dist = dist;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        K = Integer.parseInt(input[2]);

        map = new int[N][M];
        visited = new boolean[K + 1][N][M];

        for (int i = 0; i < N; i++) {
            char[] row = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                map[i][j] = row[j] - '0';
            }
        }

        System.out.println(bfs(0, 0));
    }

    static int bfs(int startR, int startC) {
        Queue<Node> q = new ArrayDeque<>();
        q.add(new Node(startR, startC, 0, 1));
        visited[0][startR][startC] = true;

        while (!q.isEmpty()) {
            Node cur = q.poll();

            if (cur.r == N - 1 && cur.c == M - 1) {
                return cur.dist;
            }

            for (int d = 0; d < 4; d++) {
                int nr = cur.r + dr[d];
                int nc = cur.c + dc[d];

                if (nr < 0 || nc < 0 || nr >= N || nc >= M) continue;

                if (map[nr][nc] == 0 && !visited[cur.broken][nr][nc]) {
                    visited[cur.broken][nr][nc] = true;
                    q.add(new Node(nr, nc, cur.broken, cur.dist + 1));
                }

                else if (map[nr][nc] == 1 && cur.broken < K && !visited[cur.broken + 1][nr][nc]) {
                    visited[cur.broken + 1][nr][nc] = true;
                    q.add(new Node(nr, nc, cur.broken + 1, cur.dist + 1));
                }
            }
        }

        return -1;
    }
}
