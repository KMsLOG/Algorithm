import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


class Point1{
	int r;
	int c;
	
	Point1(int r, int c){
		this.r = r;
		this.c = c;
	}
}

public class Main {
	static boolean[][] map;
	static int C,R,K;
	static boolean[][] visited;
	static final int[] dr = {1,-1,0,0};
	static final int[] dc = {0,0,1,-1};
	static Queue<Point1> q = new LinkedList<>();
	
	static void bfs(int r, int c) {
		q.add(new Point1(r,c));
		visited[r][c] = true;
		
		while(!q.isEmpty()) {
			Point1 cur = q.poll();
			for(int d = 0 ; d<4;d++) {
				int nr = cur.r + dr[d];
				int nc = cur.c + dc[d];
				try {
					if(map[nr][nc] && !visited[nr][nc]) {
						visited[nr][nc] = true;
						q.add(new Point1(nr,nc));
					}
				} catch (Exception e) {}
				
			}
		}
		q.clear();
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int tc = 0 ; tc<T;tc++) {
			String s = br.readLine();
			StringTokenizer st = new StringTokenizer(s);
			C = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new boolean[R][C];
			visited = new boolean[R][C];
			int cnt = 0;
			for(int i = 0 ; i<K;i++) {
				String rc = br.readLine();
				st = new StringTokenizer(rc);
				int c = Integer.parseInt(st.nextToken());
				int r = Integer.parseInt(st.nextToken());
				map[r][c] = true;
			}
			
			for(int i = 0 ;i < R ;i++) {
				for(int j = 0 ;j <C;j++) {
					if(map[i][j] && !visited[i][j]) {
						bfs(i,j);
						cnt++;
					}
				}
			}
			sb.append(cnt+"\n");
		} // end of tc
		System.out.print(sb);
	} // end of main
} // end of class
