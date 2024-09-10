import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static int max;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i = 0 ; i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0 ; i<N;i++) {
			for(int j = 0 ; j<M;j++) {
				visited[i][j] = true;
				dfs(i,j,1,map[i][j]);
				visited[i][j] = false;
				
				f(i,j,0,0,map[i][j]);
			}
		}
		
		System.out.println(max);
	} // end of main
	
	static void f(int r, int c, int start ,int depth, int sum) {
		if(depth == 3) {
			max = Math.max(max, sum);
			return;
		}
		
		for(int d = start ; d<4;d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			try {
				f(r,c,d+1,depth+1,sum+map[nr][nc]);
			} catch (Exception e) {}
		}
	} // end of f
	
	static void dfs(int r, int c, int depth, int sum) {
		if(depth==4) {
			max = Math.max(max, sum);
			return;
		}
		
		for(int d = 0 ; d<4;d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			try {
				if(!visited[nr][nc]) {
					visited[nr][nc] = true;
					dfs(nr,nc,depth+1,sum+map[nr][nc]);
					visited[nr][nc] = false;
				}
			} catch (Exception e) {}
		}
	} // end of dfs
} // end of class
