import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Nation {
    int r;
    int c;
    public Nation(int r, int c) {
        this.r = r;
        this.c = c;
    }
}

public class Main {
    static int N, L, R;
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};
    static int sum, cnt, day;
    static boolean[][] visited;
    static int[][] map;
    static int[][] copyMap;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        day = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (true) {
            visited = new boolean[N][N];
            copyMap = new int[N][N];
            boolean flag = false;

            // 인구 이동 하기
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]) {
                        if (bfs(i, j)) {
                            flag = true;
                        }
                    }
                }
            }
            // 변화가 없으면
            if (!flag) {
                break;
            }
            // 인구 이동 한거 원본 map에 저장
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (visited[i][j] && copyMap[i][j] != 0) {
                        map[i][j] = copyMap[i][j];
                    }
                }
            }
            
            day++;
        }
        System.out.println(day);
    } // end of main

    static boolean bfs(int r, int c) {
        Queue<Nation> q = new LinkedList<>();
        Queue<Nation> qq = new LinkedList<>();
        q.add(new Nation(r, c));
        qq.add(new Nation(r,c));
        visited[r][c] = true;
        sum = 0;
        cnt = 0;
        
        while (!q.isEmpty()) {
            Nation cur = q.poll();
            sum += map[cur.r][cur.c];
            cnt++;
            for (int d = 0; d < 4; d++) {
                int nr = cur.r + dr[d];
                int nc = cur.c + dc[d];
                if (nr >= 0 && nr < N && nc >= 0 && nc < N && !visited[nr][nc]) {
                    int minus = Math.abs(map[nr][nc] - map[cur.r][cur.c]);
                    if (minus >= L && minus <= R) {
                        q.add(new Nation(nr, nc));
                        qq.add(new Nation(nr,nc));
                        visited[nr][nc] = true;
                    }
                }
            }
        }

        // 변화 값 넣기
        if (cnt == 1) {
            return false;
        }
        int div = sum / cnt;

        while(!qq.isEmpty()) {
        	Nation cur = qq.poll();
        	copyMap[cur.r][cur.c] = div;
        }

        return true;
    }
}
