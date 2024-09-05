import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int R,C;
	static char[][] map;
	static int[] dr = {1,-1,0,0};
	static int[] dc = {0,0,1,-1};
	static List<Character> list = new LinkedList<>();
	static boolean[][] visited;
	static int max = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		visited = new boolean[R][C];
		for(int i = 0 ; i<R ;i++) {
			String s = br.readLine();
			for(int j = 0 ; j<C;j++) {
				map[i][j] = s.charAt(j);
			}
		}
		
		list.add(map[0][0]);
		visited[0][0] =true;
		dfs(0,0);
		System.out.println(max);
	} // end of main
	
	static void dfs(int r, int c) {
		max = Math.max(max, list.size());
		
		for(int d = 0 ; d<4 ;d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			try {
				if(!visited[nr][nc] && !list.contains(map[nr][nc])) {
					list.add(map[nr][nc]);
					visited[nr][nc] = true;
					dfs(nr,nc);
					list.remove(list.size()-1);
					visited[nr][nc] = false;
				}
			} catch (Exception e) {}
		}
	} // end of dfs;
} // end of class
