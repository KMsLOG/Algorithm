import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int N,M;
	static int[][] map;
	
	static int[] dr = {-1,0,1,0}; // 북 동 남 서
	static int[] dc = {0,1,0,-1};
	static int cnt = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		
		for(int i = 0 ; i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j<M ;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		clean(r,c,d);
		System.out.println(cnt);
	} // end of main
	static int rr = 0;
	static void clean(int r, int c, int d) {
		if(map[r][c] == 0) {
			map[r][c] = 2;
			cnt++;
		}
		boolean flag =false;

		for(int i = 3 ; i>=0;i--) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			try {
				if(map[nr][nc] == 0) {
					flag = true;
					break;
				}
			} catch (Exception e) {}
		}
		
		if(!flag) {
			int nr = r - dr[d];
			int nc = c - dc[d];
			if(nr<0||nr>=N || nc<0||nc>=M || map[nr][nc]==1) {
				return;
			} else {
				clean(nr,nc,d);
			}
		} else {
			d = (d+3)%4;
			int nr = r+dr[d];
			int nc = c+dc[d];
			if(map[nr][nc] == 0) {
				clean(nr,nc,d);
			} else {
				clean(r,c,d);
			}
			
		}
	
	} // end of clean
} // end of class
