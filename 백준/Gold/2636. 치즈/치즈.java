import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static int[][] map;
	static int lastCheese;
	static boolean[][] visited;
	static int[] dr = {1,-1,0,0};
	static int[] dc = {0,0,1,-1};
	
	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		
		for(int i = 0 ; i<N ;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j<M ;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int time = 0;
		Queue<int[]> q = new ArrayDeque<>(); // 녹일 좌표 넣는 큐
		// 끝까지 녹이기
		while(true) {
			visited = new boolean[N][M];
			air();
			
			// 치즈 세기
			int cheese = 0;
			for(int i = 0 ; i<N ;i++) {
				for(int j = 0 ; j<M;j++) {
					if(map[i][j]==1) {
						cheese+=map[i][j];
						
						
						for(int d = 0 ;d<4 ; d++) {
							int newR = i + dr[d];
							int newC = j + dc[d];
							
							if(newR<0||newC<0||newR>=N||newC>=M) continue;
							
							if(map[newR][newC]==0 && visited[newR][newC]) {
								q.add(new int[] {i,j});
							}
						}
					
					}
					
				} 
			}
			if(cheese == 0) {
				break;
			}
			lastCheese = cheese;
			while(!q.isEmpty()) {
				int[] cur = q.poll();
				map[cur[0]][cur[1]] = 0;
			}
			time++;
		}

		System.out.println(time);
		System.out.println(lastCheese);
	} // end of main
	static void air() {
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] {0,0});
		visited[0][0] = true;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int r = cur[0];
			int c = cur[1];
			
			for(int d = 0 ;d<4 ; d++) {
				int newR = r + dr[d];
				int newC = c + dc[d];
				
				if(newR<0||newC<0||newR>=N||newC>=M) continue;
				
				if(!visited[newR][newC]&&map[newR][newC]==0) {
					visited[newR][newC] = true;
					q.add(new int[] {newR,newC});
				}
			}
		}
	} // end of air
} // end of class
