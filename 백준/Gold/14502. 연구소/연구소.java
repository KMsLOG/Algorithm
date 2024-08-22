import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Point {
    int r, c;
    public Point(int r, int c) {
        this.r = r;
        this.c = c;
    }
}

public class Main {

    static int R, C;
    static int[][] map;
    static List<Point> avail;
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new int[R][C];
        avail = new ArrayList<>();

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 0) {
                    avail.add(new Point(i, j));
                }
            }
        }
        List<Point> wall = new ArrayList<>();
        comb(0, wall,3);
        System.out.println(max);
    } // end of main

    static void comb(int start, List<Point> wall,int r) {
        if (r == 0) {
            max = Math.max(max, safeArea(wall));
            return;
        }

        for (int i = start; i < avail.size(); i++) {
            wall.add(avail.get(i));
            comb(i + 1, wall, r-1);
            wall.remove(wall.size() - 1);
        }
    } // end of comb

    static int safeArea(List<Point> walls) {
        int[][] copyMap = new int[R][C];
        for (int i = 0; i < R; i++) {
            copyMap[i] = Arrays.copyOf(map[i],C);
        }

        for (Point p : walls) {
            copyMap[p.r][p.c] = 1;
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (copyMap[i][j] == 2) {
                    bfs(copyMap, new Point(i, j));
                }
            }
        }

        int cnt = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (copyMap[i][j] == 0) {
                    cnt++;
                }
            }
        }

        return cnt;
    } // end of safeArea

    static void bfs(int[][] map, Point start) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(start);
        map[start.r][start.c] = 2;

        while (!queue.isEmpty()) {
            Point cur = queue.poll();
            for (int d = 0; d < 4; d++) {
                int nr = cur.r + dr[d];
                int nc = cur.c + dc[d];
                if (nr >= 0 && nr < R && nc >= 0 && nc < C && map[nr][nc] == 0) {
                    map[nr][nc] = 2;
                    queue.add(new Point(nr, nc));
                }
            }
        }
    } // end of bfs
} // end of class
