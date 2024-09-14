import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static int[][] map;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		int r = 0;
		int c = 0;
		for(int i = 0 ;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==2) {
					r=i;
					c=j;
					map[i][j] = 0;
				}
			}
		}
		bfs(r,c);
		
		for(int i = 0 ;i<N;i++) {
			for(int j = 0 ;j<M;j++) {
				if( map[i][j]==1) {
					map[i][j] = -1;
				}
			}
		}
		
		for(int d = 0; d<4;d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			try {
				if(map[nr][nc]!=0) {
					map[nr][nc]=1;
				}
			} catch (Exception e) {}
		}
		
		for(int i = 0 ;i<N;i++) {
			for(int j = 0 ;j<M;j++) {
				sb.append(map[i][j]+" ");
			}
			sb.append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
		
	} // end of main
	static void bfs(int r, int c) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {r,c});
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int curR = cur[0];
			int curC = cur[1];
			for(int d = 0 ; d<4 ;d++) {
				int nr = curR+dr[d];
				int nc = curC+dc[d];
				if(nr>=N || nr< 0 || nc>=M || nc<0) {
					continue;
				}
				if(map[nr][nc]==1) {
					map[nr][nc] = map[nr][nc]+map[curR][curC];
					q.add(new int[] {nr,nc});
				}
			}
		}
	} // end of bfs
} // end of class
