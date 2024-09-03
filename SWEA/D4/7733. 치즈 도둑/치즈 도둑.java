import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Cheese {
    int r;
    int c;
    public Cheese(int r, int c) {
        this.r = r;
        this.c = c;
    }
}

public class Solution {
    
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,1,-1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            
            int max = 0;
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    max = Math.max(max, map[i][j]);
                }
            }
            
            int maxCnt = 0;
            
            for (int eat = 0; eat <= max; eat++) {
                int cnt = 0;
                visited = new boolean[N][N];
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        if (map[i][j] > eat && !visited[i][j]) {
                            bfs(i, j, eat);
                            cnt++;
                        }
                    }
                }
                
                maxCnt = Math.max(maxCnt, cnt);
            }
            
            sb.append("#").append(tc).append(" ").append(maxCnt).append("\n");
        }
        System.out.print(sb);
    } // end of main
    
    static void bfs(int r, int c, int eat) {
        Queue<Cheese> q = new LinkedList<>();
        q.add(new Cheese(r, c));
        visited[r][c] = true;
        
        while (!q.isEmpty()) {
            Cheese cur = q.poll();
            
            for (int d = 0; d < 4; d++) {
                int nr = cur.r + dr[d];
                int nc = cur.c + dc[d];
                try {
                	if( map[nr][nc] > eat && !visited[nr][nc]) {
                		q.add(new Cheese(nr, nc));
                        visited[nr][nc] = true;
                	}
				} catch (Exception e) {} 
            }
        }
    } // end of bfs
} // end of class
