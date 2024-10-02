import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] map;
    static boolean[][][] visited; // visited[벽을 부순 여부][r][c]
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[2][N][M]; // 벽을 부수지 않은 상태(0)와 부순 상태(1) 저장

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }

        System.out.println(bfs(0, 0));
    } // end of main

    static int bfs(int startR, int startC) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{startR, startC, 0}); // r, c, 벽 부순 여부
        visited[0][startR][startC] = true;
        int distance = 1;

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();
                int r = cur[0];
                int c = cur[1];
                int broken = cur[2];

                // 도착 지점에 도달한 경우
                if (r == N - 1 && c == M - 1) {
                    return distance;
                }

                for (int d = 0; d < 4; d++) {
                    int nr = r + dr[d];
                    int nc = c + dc[d];

                    if (nr < 0 || nc < 0 || nr >= N || nc >= M) continue;

                    if (map[nr][nc] == 0 && !visited[broken][nr][nc]) { // 벽이 없는 경우
                        visited[broken][nr][nc] = true;
                        q.add(new int[]{nr, nc, broken});
                    } else if (map[nr][nc] == 1 && broken == 0 && !visited[1][nr][nc]) { // 벽이 있는 경우
                        visited[1][nr][nc] = true;
                        q.add(new int[]{nr, nc, 1});
                    }
                }
            }
            distance++;
        }

        return -1; // 도착할 수 없는 경우
    } // end of bfs
} // end of class
