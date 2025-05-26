import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class NodeInfo {
    int r;
    int c;
    int k;
    int cnt;

    public NodeInfo(int r, int c, int k, int cnt) {
        this.r = r;
        this.c = c;
        this.k = k;
        this.cnt = cnt;
    }
}

public class Main {
    static int[][] map;
    static boolean[][][] visited;
    static int K;
    static int W;
    static int H;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int[] kdx = {-1,-2,-2,-1,1,2,2,1};
    static int[] kdy = {-2,-1,1,2,2,1,-1,-2};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[H][W];
        visited = new boolean[H][W][K+1];

        for(int i = 0 ; i<H ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<W;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = bfs(0,0);
        System.out.println(result);

    } // end of main

    public static int bfs(int r, int c) {
        Queue<NodeInfo> q = new ArrayDeque<>();

        q.add(new NodeInfo(r, c, 0, 0));
        visited[r][c][0] = true;

        while (!q.isEmpty()) {
            NodeInfo cur = q.poll();

            if (cur.r == H - 1 && cur.c == W - 1) {
                return cur.cnt;
            }

            for (int i = 0; i < 4; i++) {
                int nr = cur.r + dx[i];
                int nc = cur.c + dy[i];

                if (nr < 0 || nr >= H || nc < 0 || nc >= W || map[nr][nc] == 1 || visited[nr][nc][cur.k]) continue;

                visited[nr][nc][cur.k] = true;
                q.add(new NodeInfo(nr, nc, cur.k, cur.cnt + 1));
            }

            if (cur.k < K) {
                for (int i = 0; i < 8; i++) {
                    int nr = cur.r + kdx[i];
                    int nc = cur.c + kdy[i];

                    if (nr < 0 || nr >= H || nc < 0 || nc >= W || map[nr][nc] == 1 || visited[nr][nc][cur.k + 1]) continue;

                    visited[nr][nc][cur.k + 1] = true;
                    q.add(new NodeInfo(nr, nc, cur.k + 1, cur.cnt + 1));
                }
            }
        }
        return -1;
    } // end of bfs
} // end of class
