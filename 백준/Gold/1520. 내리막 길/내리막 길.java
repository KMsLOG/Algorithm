import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static int[][] map;
	static int[][] dp;
	static boolean[][] visited;
	static int cnt = 0;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visited = new boolean[N][M];
		dp = new int[N][M];
		
		for(int i = 0 ; i<N ;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j<M ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		System.out.println(dfs(0,0));
	} // end of main
	
	static int dfs(int r, int c) {
		if(visited[r][c]) {
			return dp[r][c];
		}
		
		if(r == N-1 && c==M-1) {
			return 1;
		}
		for(int d = 0 ; d<4 ; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if(nr<0 || nc <0 || nr>=N || nc>=M) continue;
			
			if(map[nr][nc]<map[r][c] ) {
				dp[r][c] +=dfs(nr,nc);
			}
		}
		visited[r][c] = true;
		return dp[r][c];
	} // end of dfs
} // end of class
