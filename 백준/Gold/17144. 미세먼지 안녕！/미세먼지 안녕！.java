import java.io.*;
import java.util.*;

public class Main {

    static int R, C, T;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static List<int[]> purifier = new ArrayList<>();
    static int[][] map;
    static Queue<Dust> q = new ArrayDeque<>();

    static class Dust {
        int r, c, amount;
        public Dust(int r, int c, int amount) {
            this.r = r;
            this.c = c;
            this.amount = amount;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        map = new int[R][C];

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == -1) purifier.add(new int[]{i, j});
            }
        }

        while (T-- > 0) {
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (map[i][j] > 0) {
                        spread(i, j);
                    }
                }
            }

            while (!q.isEmpty()) {
                Dust cur = q.poll();
                map[cur.r][cur.c] += cur.amount;
            }

            int[] upper = purifier.get(0);
            int[] lower = purifier.get(1);

            purifyUpper(upper[0]);
            purifyLower(lower[0]);
        }

        int answer = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] > 0) answer += map[i][j];
            }
        }
        System.out.println(answer);
    }

    static void spread(int r, int c) {
        int spreadAmount = map[r][c] / 5;
        int cnt = 0;

        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            if (nr < 0 || nr >= R || nc < 0 || nc >= C || map[nr][nc] == -1)
                continue;

            q.add(new Dust(nr, nc, spreadAmount));
            cnt++;
        }
        map[r][c] -= spreadAmount * cnt;
    }

    static void purifyUpper(int r) {
        for (int i = r - 1; i > 0; i--) map[i][0] = map[i - 1][0];
        for (int i = 0; i < C - 1; i++) map[0][i] = map[0][i + 1];
        for (int i = 0; i < r; i++) map[i][C - 1] = map[i + 1][C - 1];
        for (int i = C - 1; i > 1; i--) map[r][i] = map[r][i - 1];
        map[r][1] = 0;
    }

    static void purifyLower(int r) {
        for (int i = r + 1; i < R - 1; i++) map[i][0] = map[i + 1][0];
        for (int i = 0; i < C - 1; i++) map[R - 1][i] = map[R - 1][i + 1];
        for (int i = R - 1; i > r; i--) map[i][C - 1] = map[i - 1][C - 1];
        for (int i = C - 1; i > 1; i--) map[r][i] = map[r][i - 1];
        map[r][1] = 0;
    }
}
