import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] map;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int year = 0;
        boolean flag = true;
        while (true) {
            if (divCheck()) { // 분리 체크
                break;
            }
            iceMelt();

            boolean check = false;
            for (int i = 1; i < N - 1; i++) {
                for (int j = 1; j < M - 1; j++) {
                    if (map[i][j] > 0) {
                        check = true;
                        break;
                    }
                }
                if (check) break;
            }

            if (!check) {
                flag = false;
                break;
            }

            year++;
        }

        System.out.println(flag ? year : 0);
    } // end of main

    static boolean divCheck() {
        boolean[][] visited = new boolean[N][M];
        Queue<int[]> q = new ArrayDeque<>();
        int startR = -1;
        int startC = -1;

        for (int i = 1; i < N - 1; i++) {
            for (int j = 1; j < M - 1; j++) {
                if (!visited[i][j] && map[i][j] > 0) {
                    startR = i;
                    startC = j;
                    break;
                }
            }
            if (startR != -1) break;
        }

        if (startR == -1) { // 다 0이면
            return false;
        }

        q.add(new int[]{startR, startC});
        visited[startR][startC] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int d = 0; d < 4; d++) {
                int nr = cur[0] + dr[d];
                int nc = cur[1] + dc[d];

                if (nr >= 0 && nr < N && nc >= 0 && nc < M && !visited[nr][nc] && map[nr][nc] > 0) {
                    q.add(new int[]{nr, nc});
                    visited[nr][nc] = true;
                }
            }
        }

        for (int i = 1; i < N - 1; i++) {
            for (int j = 1; j < M - 1; j++) {
                if (!visited[i][j] && map[i][j] > 0) {
                    return true; // 분리된 빙산이 존재
                }
            }
        }

        return false;
    } // end of divCheck

    static void iceMelt() {
        int[][] newMap = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                newMap[i][j] = map[i][j];
            }
        }

        for (int i = 1; i < N - 1; i++) {
            for (int j = 1; j < M - 1; j++) {
                if (map[i][j] > 0) {
                    int melt = 0;
                    for (int d = 0; d < 4; d++) {
                        int nr = i + dr[d];
                        int nc = j + dc[d];
                        if (map[nr][nc] == 0) {
                            melt++;
                        }
                    }
                    newMap[i][j] = Math.max(0, map[i][j] - melt);
                }
            }
        }
        map = newMap;
    } // end of iceMelt
} // end of class
