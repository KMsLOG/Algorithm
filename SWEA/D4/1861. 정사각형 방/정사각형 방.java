import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;



public class Solution {
	
	static int N;
	static int[][] map;
	static boolean[][] visited;
	static int maxcnt;
	static int cnt;
	static int[] dr = {1,-1,0,0};
	static int[] dc = {0,0,1,-1};

	static void dfs(int r , int c) {
		visited[r][c] = true;
		cnt++;
		for(int d = 0 ;d<4;d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if(nr>=N || nr<0 || nc>=N || nc<0) {
				continue;
			}
			
			if(map[nr][nc] == map[r][c]+1 && !visited[nr][nc]) {
				dfs(nr,nc);
			}
			
		}
	}
	
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc<=T ; tc++) {
			maxcnt = 0;
			N = Integer.parseInt(br.readLine());
			PriorityQueue<Integer> pq = new PriorityQueue<>();
			
			map = new int[N][N];
			visited = new boolean[N][N];
			
			// map에 값넣기
			for(int i = 0 ; i<N;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0 ; j<N;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			
			for(int i = 0 ; i<N;i++) {
				for(int j = 0 ; j<N;j++) {
					visited = new boolean[N][N];
					cnt = 0;
					dfs(i,j);
					if(maxcnt<cnt) {
						maxcnt = cnt;
						pq.clear();
						pq.add(map[i][j]);
					} else if(maxcnt == cnt) {
						pq.add(map[i][j]);
					}
				}
			}
			
			
			sb.append("#"+tc+" "+pq.poll()+" "+maxcnt+"\n");
		} // end of tc
		System.out.print(sb);
	} // end of main
} //  end of class
