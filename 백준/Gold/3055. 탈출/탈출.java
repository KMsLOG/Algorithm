import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int R, C;
    static char[][] map;
    static boolean[][] visited;
    static int[][] cnt;
    static Queue<int[]> water = new ArrayDeque<>();
    static Queue<int[]> q = new ArrayDeque<>();
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        visited = new boolean[R][C];
        cnt = new int[R][C];

        int startR = -1;
        int startC = -1;
        
        int endR = -1;
        int endC = -1;
        
        for (int i = 0; i < R; i++) {
            String s = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = s.charAt(j);
                if (map[i][j] == 'D') {
                    endR = i;
                    endC = j;
                } else if (map[i][j] == 'S') {
                    startR = i;
                    startC = j;
                } else if (map[i][j] == '*') {
                    water.add(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }

        // 사람의 시작 위치를 큐에 추가
        q.add(new int[]{startR, startC});
        visited[startR][startC] = true;

        bfs();

        
        System.out.println(cnt[endR][endC]!=0?cnt[endR][endC] : "KAKTUS");
    } // end of main

    static void bfs() {
        while (!q.isEmpty()) {
            // 물 확산
            int waterSize = water.size();
            for (int i = 0; i < waterSize; i++) {
                int[] waterCur = water.poll();
                int waterR = waterCur[0];
                int waterC = waterCur[1];

                for (int d = 0; d < 4; d++) {
                    int nWaterR = waterR + dr[d];
                    int nWaterC = waterC + dc[d];

                    if (nWaterR < 0 || nWaterC < 0 || nWaterR >= R || nWaterC >= C) continue;

                    if (map[nWaterR][nWaterC] == '.') {
                        map[nWaterR][nWaterC] = '*';
                        water.add(new int[]{nWaterR, nWaterC});
                    }
                }
            }

            // 사람 이동
            int personSize = q.size();
            for (int i = 0; i < personSize; i++) {
                int[] cur = q.poll();
                int curR = cur[0];
                int curC = cur[1];

                for (int d = 0; d < 4; d++) {
                    int nr = curR + dr[d];
                    int nc = curC + dc[d];

                    if (nr < 0 || nc < 0 || nr >= R || nc >= C) continue;

                    if (!visited[nr][nc] && (map[nr][nc] == '.' || map[nr][nc] == 'D')) {
                        visited[nr][nc] = true;
                        cnt[nr][nc] = cnt[curR][curC] + 1;
                        q.add(new int[]{nr, nc});
                    }
                }
            }
        }
    } // end of dfs
} // end of class
