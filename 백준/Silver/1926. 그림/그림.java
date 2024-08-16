import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Painting{
	int r;
	int c;
	public Painting(int r, int c) {
		this.r = r;
		this.c = c;
	}
	
}

public class Main {
	
	static int R,C;
	static boolean[][] map;
	static boolean[][] visited;
	static final int[] dr = {1,-1,0,0};
	static final int[] dc = {0,0,1,-1};
	static Queue<Painting> q = new LinkedList<>();
	static int max = 0;
	static int cnt = 0;
	static int extent = 0;
	
	static void bfs(int r, int c) {
		q.add(new Painting(r, c));
		visited[r][c] = true;
		extent++;
		while(!q.isEmpty()) {
			Painting cur = q.poll();
			for(int d = 0 ;d<4;d++) {
				int nr = cur.r+dr[d];
				int nc = cur.c+dc[d];
				
				try {
					if(map[nr][nc] && !visited[nr][nc]) {
						extent++;
						visited[nr][nc] = true;
						q.add(new Painting(nr, nc));
					}
				} catch (Exception e) {}
			}
		}
		q.clear();
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		String rc = br.readLine();
		StringTokenizer st = new StringTokenizer(rc);
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new boolean[R][C];
		visited = new boolean[R][C];
		
		for(int i = 0 ; i<R;i++) {
			String s = br.readLine();
			st = new StringTokenizer(s);
			for(int j = 0 ; j<C;j++) {
				int num = Integer.parseInt(st.nextToken());
				if(num == 1) {
					map[i][j] = true;
				}
			}
		}
		
		for(int i = 0 ; i<R;i++) {
			for(int j = 0 ; j<C;j++) {
				if(map[i][j] && !visited[i][j]) {
					extent= 0;
					bfs(i,j);
					cnt++;
					if(max<extent) {
						max = extent;
					}
				}
			}
		}
		
		
		System.out.println(cnt);
		System.out.println(max);
	} // end of main
} // end of class
