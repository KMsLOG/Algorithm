import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static char[][] map;
    static int[][] state;
    static int cnt = 0;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        state = new int[N][M];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (state[i][j] == 0) {
                    dfs(i, j);
                }
            }
        }

        System.out.println(cnt);
    } // end of main

    static void dfs(int r, int c) {
        if (state[r][c] == 1) {
            cnt++;
            return;
        }
        if (state[r][c] == 2) {
            return;
        }

        state[r][c] = 1;

        int[] nextMove = move(map[r][c]);
        int nr = r + nextMove[0];
        int nc = c + nextMove[1];

        dfs(nr, nc);

        state[r][c] = 2;
    } // end of dfs

    static int[] move(char c) {
        if (c == 'D') {
            return (new int[]{1, 0});
        } else if (c == 'U') {
            return (new int[]{-1, 0});
        } else if (c == 'L') {
            return (new int[]{0, -1});
        } else {
            return (new int[]{0, 1});
        }
    } // end of move
} // end of class