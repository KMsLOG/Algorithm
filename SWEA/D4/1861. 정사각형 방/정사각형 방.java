import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;



public class Solution {
	
	static int N;
	static int[][] map;
	static int maxCnt;
	static int roomNum;
	static int maxRoomNum;
	static int[] dr = {1,-1,0,0};
	static int[] dc = {0,0,1,-1};

	static void dfs(int count , int r , int c) {
		if(maxCnt<count) {
			maxCnt = count;
			maxRoomNum = roomNum;
		} else if(maxCnt == count && maxRoomNum > roomNum) {
			maxRoomNum = roomNum;
		}
		for(int d = 0 ;d<4;d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if(nr>=N || nr<0 || nc>=N || nc<0) {
				continue;
			}
			
			if(map[nr][nc] == map[r][c]+1) {
				dfs(count+1, nr,nc);
			}
			
		}
	}
	
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc<=T ; tc++) {
			N = Integer.parseInt(br.readLine());
			
			map = new int[N][N];
			
			// map에 값넣기
			for(int i = 0 ; i<N;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0 ; j<N;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			maxRoomNum = 1;
			maxCnt = 0;
			
			for(int i = 0 ; i<N;i++) {
				for(int j = 0 ; j<N;j++) {
					roomNum = map[i][j];
					dfs(1,i,j);
				}
			}
			
			
			sb.append("#"+tc+" "+maxRoomNum+" "+maxCnt+"\n");
		} // end of tc
		System.out.print(sb);
	} // end of main
} //  end of class
