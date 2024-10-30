import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int maxLen = 0;
	static int N,M;
	static char[][] map;
	static int[] dr = {1,-1,0,0};
	static int[] dc = {0,0,1,-1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char[N][M];
		
		for(int i = 0 ;i<N ;i++) {
			String s = br.readLine();
			map[i] = s.toCharArray();
		}
		
		for(int i = 0 ; i<N ;i++) {
			for(int j = 0 ;j<M ; j++) {
				if(map[i][j]=='L') {
					bfs(i,j);
				}
			}
		}
		
		System.out.println(maxLen);
	} // end of main
	
    static void bfs(int r, int c) {
        boolean[][] visited = new boolean[N][M];
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{r, c});
        visited[r][c] = true;
        int len = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();
                int curR = cur[0];
                int curC = cur[1];

                for (int d = 0; d < 4; d++) {
                    int newR = curR + dr[d];
                    int newC = curC + dc[d];
                    if (newR < 0 || newC < 0 || newR >= N || newC >= M) continue;

                    if (map[newR][newC] == 'L' && !visited[newR][newC]) {
                        visited[newR][newC] = true;
                        q.add(new int[]{newR, newC});
                    }
                }
            }
            len++;
        }

        maxLen = Math.max(maxLen, len - 1);
    } // end of bfs
} // end of class
