import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class RGB {
    char color;
    int r;
    int c;

    public RGB(char color, int r, int c) {
        this.color = color;
        this.r = r;
        this.c = c;
    }
}

public class Main {
    static final int[] dr = {1, -1, 0, 0};
    static final int[] dc = {0, 0, 1, -1};
    static int N;
    static char[][] map;
    static boolean[][] visited;

    static void bfs(RGB start, boolean colorBlind) {
        Queue<RGB> queue = new LinkedList<>();
        queue.add(start);
        visited[start.r][start.c] = true;

        while (!queue.isEmpty()) {
            RGB cur = queue.poll();
            for (int d = 0; d < 4; d++) {
                int nr = cur.r + dr[d];
                int nc = cur.c + dc[d];

                if (isValid(nr, nc) && !visited[nr][nc]) {
                    boolean sameColor = (colorBlind && (cur.color == 'R' || cur.color == 'G') && (map[nr][nc] == 'R' || map[nr][nc] == 'G')) || (cur.color == map[nr][nc]);
                    if (sameColor) {
                        queue.add(new RGB(map[nr][nc], nr, nc));
                        visited[nr][nc] = true;
                    }
                }
            }
        }
    }

    static boolean isValid(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < N;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        int normalCount = 0;
        int colorBlindCount = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    bfs(new RGB(map[i][j], i, j), false);
                    normalCount++;
                }
            }
        }

        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    bfs(new RGB(map[i][j], i, j), true);
                    colorBlindCount++;
                }
            }
        }

        System.out.println(normalCount + " " + colorBlindCount);
    }
}
