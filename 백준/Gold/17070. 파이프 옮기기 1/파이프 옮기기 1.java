import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[][] map;
	static int[][] dr = {{0,1}, // 가로인 경우
						{1,1},	// 세로인 경우
						{0,1,1}}; // 대각선인 경우
	
	static int[][] dc = {{1,1}, // 가로인 경우
						{0,1}, // 세로인 경우
						{1,0,1}}; // 대각선인 경우
	
	static int cnt = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		for(int i = 0 ;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j<n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dfs(0,1,0); 
		System.out.println(cnt);
	} // end of main
	
	static void dfs(int r, int c,int dir) { // d : 0 - 가로 | 1 - 세로 | 2 - 대각선
		if(r == n-1 && c == n-1) {
			cnt++;
			return;
		}
		
		// 가로인 경우
		if(dir == 0) {
			for(int d = 0 ;d<2;d++) {
				int nr = r + dr[0][d];
				int nc = c + dc[0][d];
				try {
					if(d==0) { // 가로인 경우
						if(check(nr,nc)) {
							dfs(nr,nc,0);
						}
					} else { // 대각선인 경우
						if(checkDiag(nr, nc)) {
							dfs(nr,nc,2);
						}
					}
				} catch (Exception e) {}
			}
		}
		// 세로인 경우
		if(dir == 1) {
			for(int d = 0 ;d<2;d++) {
				int nr = r + dr[1][d];
				int nc = c + dc[1][d];
				try {
					if(d==0) { // 세로인 경우
						if(check(nr,nc)) {
							dfs(nr,nc,1);
						}
					} else { // 대각선인 경우
						if(checkDiag(nr, nc)) {
							dfs(nr,nc,2);
						}
					}
				} catch (Exception e) {}
			}
		}
		// 대각선인 경우
		if(dir == 2) {
			for(int d = 0 ;d<3;d++) {
				int nr = r + dr[2][d];
				int nc = c + dc[2][d];
				try {
					if(d<2) { // 가로인 경우
						if(check(nr,nc)) {
							dfs(nr,nc,d);
						}
					} else { // 대각선인 경우
						if(checkDiag(nr, nc)) {
							dfs(nr,nc,2);
						}
					}
				} catch (Exception e) {}
			}
		}
	} // end of dfs
	
	// 가로,세로 판별
	static boolean check(int r, int c) {
		if(map[r][c] == 1) {
			return false;
		}
		return true;
	} // end of check
	
	// 대각선 판별
	static boolean checkDiag(int r, int c) {
		if(map[r][c] == 1 || map[r-1][c] == 1 || map[r][c-1]==1) {
			return false;
		}
		return true;
	} // end of checkDiag
	
} // end of class
