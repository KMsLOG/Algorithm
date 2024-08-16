import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Chess {
    int r;
    int c;
    public Chess(int r, int c) {
        this.r = r;
        this.c = c;
    }
}

public class Main {
    static int I;
    static int[][] map;
    static int[] dr = {-2, -2, -1, -1, 1, 1, 2, 2};    
    static int[] dc = {-1, 1, -2, 2, -2, 2, -1, 1};    
    static Chess[] chess = new Chess[2];
    
    static void bfs(Chess start, Chess end) {
        Queue<Chess> q = new LinkedList<>();
        q.add(start);
        map[start.r][start.c] = 1;  // Starting point
        
        while (!q.isEmpty()) {
            Chess temp = q.poll();
            if (temp.r == end.r && temp.c == end.c) {
                System.out.println(map[temp.r][temp.c] - 1);
                return;
            }
            for (int d = 0; d < 8; d++) {
                int nr = temp.r + dr[d];
                int nc = temp.c + dc[d];
                if (nr >= 0 && nr < I && nc >= 0 && nc < I && map[nr][nc] == 0) {
                    map[nr][nc] = map[temp.r][temp.c] + 1;
                    q.add(new Chess(nr, nc));
                }
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            I = Integer.parseInt(br.readLine());
            map = new int[I][I];  // Initialize map to 0
            
            for (int i = 0; i < 2; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int r = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                chess[i] = new Chess(r, c);
            }
            
            if (chess[0].r == chess[1].r && chess[0].c == chess[1].c) {
                System.out.println(0);
            } else {
                bfs(chess[0], chess[1]);
            }
        }
    }
}
