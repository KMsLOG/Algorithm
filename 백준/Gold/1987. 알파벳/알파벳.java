import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int R,C;
	static char[][] map;
	static int[] dr = {1,-1,0,0};
	static int[] dc = {0,0,1,-1};
	static boolean[] visited;
	static int max = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		visited = new boolean[26];
		for(int i = 0 ; i<R ;i++) {
			String s = br.readLine();
			for(int j = 0 ; j<C;j++) {
				map[i][j] = s.charAt(j);
			}
		}
		visited[map[0][0]-'A'] = true;
		dfs(0,0,1);
		System.out.println(max);
	} // end of main
	
	static void dfs(int r, int c, int cnt) {
		max = Math.max(max, cnt);
		
		for(int d = 0 ; d<4 ;d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			try {
				if(!visited[map[nr][nc]-'A']) {
					visited[map[nr][nc] - 'A'] = true;
					dfs(nr,nc,cnt+1);
					visited[map[nr][nc] - 'A'] = false;
				}
			} catch (Exception e) {}
		}
	} // end of dfs;
} // end of class
