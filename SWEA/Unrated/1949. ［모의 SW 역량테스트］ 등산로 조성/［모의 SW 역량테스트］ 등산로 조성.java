import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

class Mountain{
	int r;
	int c;
	public Mountain(int r, int c) {
		this.r = r;
		this.c = c;
	}
}

public class Solution {
	
	static int N,K,maxH,ans;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = {1,-1,0,0};
	static int[] dc = {0,0,1,-1};
	
	public static void main(String[] args) throws  IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1 ;tc<=T;tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			map = new int[N][N];
			visited = new boolean[N][N];
			maxH = 0;
			ans = 0;
			
			for(int i = 0 ;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0 ;j<N;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(maxH <map[i][j]) {
						maxH = map[i][j];
					}
				}
			}
			
			for(int i = 0 ;i<N;i++) {
				for(int j = 0 ;j<N;j++) {
					if(map[i][j]==maxH) {
						dfs(i,j,1,true);
					}
				}
			}
			
			sb.append("#"+tc+" "+ans +"\n");
		} // end of tc
		System.out.print(sb);
	} // end of main
	
	static void dfs(int r, int c, int cnt, boolean skill) {
		ans = Math.max(cnt, ans);
		visited[r][c] = true;
		for(int d = 0 ; d<4 ; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			try {
				if(!visited[nr][nc]&&map[r][c] > map[nr][nc]) {
					dfs(nr,nc,cnt+1,skill);
				} else if(!visited[nr][nc]&&skill & map[r][c] > map[nr][nc]-K) {
					int tmp = map[nr][nc];
					map[nr][nc] = map[r][c]-1;
					dfs(nr,nc,cnt+1,false);
					map[nr][nc] = tmp;
				}
			} catch (Exception e) {}
		}
		visited[r][c] =false;
	}
} // end of class
