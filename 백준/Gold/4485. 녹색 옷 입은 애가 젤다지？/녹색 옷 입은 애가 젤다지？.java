import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] map;
	static int[][] cnt;
	static int INF = Integer.MAX_VALUE;
	static int[] dr = {1,-1,0,0};
	static int[] dc = {0,0,1,-1};
	static class Node{
		int r;
		int c;
		
		public Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int idx = 1;
		while(true) {
			N = Integer.parseInt(br.readLine());
			if(N==0) break;
			
			map = new int[N][N];
			cnt = new int[N][N];
			
			for(int i = 0 ; i<N ;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0 ;j<N ;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					cnt[i][j] = INF;
				}
			}
			int minCnt = bfs(new Node(0,0));
			sb.append("Problem "+idx+": "+minCnt+"\n");
			idx++;
		} // end of while
		System.out.print(sb);
	} // end of main
	private static int bfs(Node start) {
		Queue<Node> q = new ArrayDeque<>();
		q.add(start);
		cnt[0][0] = map[0][0];
		
		while(!q.isEmpty()) {
			Node cur = q.poll();
			if(cur.r == N-1 && cur.c ==N-1) continue;
			for(int d = 0 ;d <4 ;d++) {
				int nr = cur.r+dr[d];
				int nc = cur.c+dc[d];
				if(nr>=N || nc>=N || nr<0 || nc<0) continue;
				
				if(cnt[nr][nc]>cnt[cur.r][cur.c]+map[nr][nc]) {
					cnt[nr][nc] = cnt[cur.r][cur.c]+map[nr][nc];
					q.add(new Node(nr,nc));
				}
			}
		}
		
		return cnt[N-1][N-1];
	}
} // end of class
