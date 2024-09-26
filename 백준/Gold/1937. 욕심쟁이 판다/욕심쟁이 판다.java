import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] map;
	static int[][] dp;
	static boolean[][] visited;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,1,-1};
	static int maxcnt = 0;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		dp = new int[N][N];
		visited = new boolean[N][N];
		
		for(int i = 0 ;i<N ;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j<N ;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0 ;i<N ;i++) {
			for(int j = 0 ; j<N ;j++) {
				if(!visited[i][j]) {
					maxcnt = Math.max(maxcnt,dfs(i,j));
				}
			}
		}
		
		System.out.println(maxcnt);
	} // end of main
	
	static int dfs(int r, int c) {
		if(visited[r][c]) {
			return dp[r][c];
		}
		boolean ok = true;
	
		for(int d = 0 ;d<4 ;d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if(nr<0 || nc<0 || nr>=N || nc>=N) continue;
			
			if(map[nr][nc]>map[r][c] ) {
				ok = false;
				dp[r][c] = Math.max(dp[r][c], dfs(nr,nc)+1);
				visited[r][c] = true;
			}
		}
		if(ok) {
			visited[r][c] = true;
			dp[r][c] = 1;
			return dp[r][c];
		}
		
		
		return dp[r][c];
	}
} // end of class
