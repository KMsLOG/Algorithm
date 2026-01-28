import java.io.*;
import java.util.*;

public class Main {

    static class Fireball {
        int r, c, m, s, d;
        public Fireball(int r, int c, int m, int s, int d) {
            this.r = r;
            this.c = c;
            this.m = m;
            this.s = s;
            this.d = d;
        }
    }

    static int N, M, K;
    static int[] dr = {-1,-1,0,1,1,1,0,-1};
    static int[] dc = {0,1,1,1,0,-1,-1,-1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        Deque<Fireball> q = new ArrayDeque<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            q.add(new Fireball(r, c, m, s, d));
        }

        for (int t = 0; t < K; t++) {
            List<Fireball>[][] board = new ArrayList[N][N];
            for (int i = 0; i < N; i++)
                for (int j = 0; j < N; j++)
                    board[i][j] = new ArrayList<>();

            while (!q.isEmpty()) {
                Fireball f = q.poll();
                int nr = (f.r + dr[f.d] * f.s % N + N) % N;
                int nc = (f.c + dc[f.d] * f.s % N + N) % N;
                board[nr][nc].add(new Fireball(nr, nc, f.m, f.s, f.d));
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    int size = board[i][j].size();
                    if (size == 0) continue;
                    if (size == 1) {
                        q.add(board[i][j].get(0));
                    } else {
                        int sumM = 0, sumS = 0;
                        boolean allEven = true, allOdd = true;

                        for (Fireball f : board[i][j]) {
                            sumM += f.m;
                            sumS += f.s;
                            if (f.d % 2 == 0) allOdd = false;
                            else allEven = false;
                        }

                        int newM = sumM / 5;
                        if (newM == 0) continue;
                        int newS = sumS / size;

                        int[] dirs = (allEven || allOdd) ? new int[]{0,2,4,6} : new int[]{1,3,5,7};
                        for (int d : dirs) {
                            q.add(new Fireball(i, j, newM, newS, d));
                        }
                    }
                }
            }
        }

        int answer = 0;
        for (Fireball f : q) {
            answer += f.m;
        }
        System.out.println(answer);
    }
}
