import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int C,R;
	static int[][] map;
	static int[][] COST;
	static int[] dr = {1,-1,0,0};
	static int[] dc = {0,0,1,-1};
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		C = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		COST = new int[R][C];
		int INF = Integer.MAX_VALUE;
		for(int i = 0 ; i<R ;i++) {
			String s = br.readLine();
			for(int j = 0 ; j<C ;j++) {
				map[i][j] = s.charAt(j)-'0';
				COST[i][j] = INF;
			}
		}
		
		int result = dijkstra(0, 0, R-1, C-1);
		
		System.out.println(result);
	} // end of main
	
	static int dijkstra(int startR,int startC, int endR, int endC) {
		Queue<int[]> q = new LinkedList<>();
		int[] num = {startR,startC};
		q.add(num);
		COST[startR][startC] = 0;
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			for(int d = 0 ; d<4;d++) {
				int nr = cur[0] + dr[d];
				int nc = cur[1] + dc[d];
				try {
					if(COST[nr][nc] > COST[cur[0]][cur[1]] + map[nr][nc]) {
						COST[nr][nc] = COST[cur[0]][cur[1]] + map[nr][nc];
						int[] newint = {nr,nc};
						q.add(newint);
					}
				} catch (Exception e) {}
				
			}
		}
		return COST[endR][endC];
	}
} // end of class
