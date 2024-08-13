import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static boolean[][]visit;
	static final int[] dx = {-1,0,1,-1,1,-1,0,1};
	static final int[] dy = {1,1,1,0,0,-1,-1,-1};
	static int[][] map;
	static int w;
	static int h;
	
	// dfs
	static void dfs(int i, int j) {
		visit[i][j] = true;	// 해당 섬 방문
		
		for(int d = 0 ; d < 8 ;d++) { // 8방향으로 갈 수 있는 섬 찾아보기
			int nr = i + dx[d];
			int nc = j + dy[d];
			
			if(nr>= h || nr<0 || nc>=w || nc<0) {
				continue;
			}
			if(map[nr][nc] == 1 && visit[nr][nc] == false ) { // 섬이 이어져있으면
				dfs(nr,nc);
			} 
		}
	} // end of dfs
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true) {
			String[] nm = br.readLine().split(" ");
			w = Integer.parseInt(nm[0]); // 너비
			h = Integer.parseInt(nm[1]); // 높이
			int cnt = 0 ; // 섬의 개수
			// 0 0 이면 반복문 탈출
			if(w==0 &&h==0) {
				break;
			}
			
			// 지도 만들기
			map = new int[h][w];
			visit = new boolean[h][w];
			for(int i = 0 ; i<h;i++) {
				String s = br.readLine();
				StringTokenizer st = new StringTokenizer(s);
				for(int j = 0 ; j<w;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			// 섬 찾기
			for(int i = 0 ; i<h;i++) {
				for(int j = 0 ; j<w;j++) {
					if(map[i][j] == 1 && visit[i][j]==false) {
						dfs(i,j);
						cnt++; // 섬 찾았으면 카운트에 1더하기
					}
				}
			}
			sb.append(cnt+"\n");
		} // end of tc
		System.out.println(sb);
	} // end of main
} // end of class
