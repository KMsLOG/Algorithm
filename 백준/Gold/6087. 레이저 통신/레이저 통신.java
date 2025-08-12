import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Node implements Comparable<Node> {
    int r;
    int c;
    int dir;
    int mirCnt;

    public Node(int r, int c, int dir, int mirCnt) {
        this.r = r;
        this.c = c;
        this.dir = dir;
        this.mirCnt = mirCnt;
    }

    @Override
    public int compareTo(Node o) {
        return this.mirCnt - o.mirCnt;
    }
}

public class Main {
    static int W, H;
    static char[][] map;
    static int[][][] cnt;
    static List<int[]> coord;
    static int[] dr = {0, 0, -1, 1};
    static int[] dc = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        map = new char[H][W];
        cnt = new int[H][W][4];
        coord = new ArrayList<>();

        for (int i = 0; i < H; i++) {
            String s = br.readLine();
            for (int j = 0; j < W; j++) {
                map[i][j] = s.charAt(j);
                if (map[i][j] == 'C') {
                    coord.add(new int[]{i, j});
                }
                for(int k = 0 ;k<4;k++){
                    cnt[i][j][k] = Integer.MAX_VALUE;
                }
            }
        }

        System.out.println(dijkstra(coord.get(0), coord.get(1)));
    } // end of main

    static int dijkstra(int[] start, int[] end) {
        PriorityQueue<Node> pq = new PriorityQueue<>();

        for (int i = 0; i < 4; i++) {
            cnt[start[0]][start[1]][i] = 0;
            pq.add(new Node(start[0], start[1], i, 0));
        }

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            // 원래 경로가 더 적으면 스킵
            if (cur.mirCnt > cnt[cur.r][cur.c][cur.dir]) continue;

            if (cur.r == end[0] && cur.c == end[1]) return cur.mirCnt;

            for (int d = 0; d < 4; d++) {
                int nr = cur.r + dr[d];
                int nc = cur.c + dc[d];
                int nextMirCnt = cur.mirCnt;

                if (nr < 0 || nr >= H || nc < 0 || nc >= W || map[nr][nc] == '*') continue;

                // 방향이 바뀌면 증가
                if (cur.dir != d) nextMirCnt++;

                // 거울 개수가 더 적으면
                if (nextMirCnt < cnt[nr][nc][d]) {
                    cnt[nr][nc][d] = nextMirCnt;
                    pq.add(new Node(nr, nc, d, nextMirCnt));
                }
            }
        }
        return -1;
    } // end of dijkstra
} // end of class