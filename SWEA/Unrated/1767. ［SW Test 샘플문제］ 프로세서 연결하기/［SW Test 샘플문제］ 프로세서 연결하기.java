import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Core {
    int r;
    int c;

    public Core(int r, int c) {
        this.r = r;
        this.c = c;
    }
}

public class Solution {
    static int N;
    static int[][] map;
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static List<Core> list;
    static int maxCore;
    static int minLen;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            list = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if (i > 0 && i < N - 1 && j > 0 && j < N - 1 && map[i][j] == 1) {
                        list.add(new Core(i, j));
                    }
                }
            }
            maxCore = 0;
            minLen = Integer.MAX_VALUE;
            dfs(0, 0);
            sb.append("#").append(tc).append(" ").append(minLen).append("\n");
        }
        System.out.print(sb);
    } // end of main

    static void dfs(int index, int count) {
        if (index == list.size()) {
            if (count > maxCore) {
                maxCore = count;
                minLen = calculateLength();
            } else if (count == maxCore) {
                minLen = Math.min(minLen, calculateLength());
            }
            return;
        }

        int r = list.get(index).r;
        int c = list.get(index).c;

        for (int d = 0; d < 4; d++) {
            if (check(r, c, d)) {
                int length = fill(r, c, d, 2);
                dfs(index + 1, count + 1);
                fill(r, c, d, 0);
            }
        }

        dfs(index + 1, count); 
    } // end of dfs

    static boolean check(int r, int c, int d) {
        while (true) {
            r += dr[d];
            c += dc[d];
            if (r < 0 || r >= N || c < 0 || c >= N) {
                return true;
            }
            if (map[r][c] != 0) {
                return false;
            }
        }
    } // end of check

    static int fill(int r, int c, int d, int cover) {
        int length = 0;
        while (true) {
            r += dr[d];
            c += dc[d];
            if (r < 0 || r >= N || c < 0 || c >= N) {
                break;
            }
            map[r][c] = cover;
            length++;
        }
        return length;
    } // end of fill

    static int calculateLength() {
        int length = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 2) {
                    length++;
                }
            }
        }
        return length;
    } // end of calculateLength
} // end of class
