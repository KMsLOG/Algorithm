import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
class RGB{
	char color;
	int r;
	int c;
	public RGB(char color, int r, int c) {
		this.color = color;
		this.r = r;
		this.c = c;
	}
	@Override
	public String toString() {
		return "RGB [color=" + color + ", r=" + r + ", c=" + c + "]";
	}
	
}


public class Main {
	static int N;
	static char[][] map;
	static boolean[][] visited;
	static int[] dr = {1,-1,0,0};
	static int[] dc = {0,0,1,-1};
	static int cnt = 0;
	static int nocnt = 0;
	static void bfs(RGB rgb) {
		Queue<RGB> q = new LinkedList<>();
		q.add(rgb);
		visited[rgb.r][rgb.c] = true;
		
		while(!q.isEmpty()) {
			RGB cur = q.poll();
			for(int d = 0; d<4;d++) {
				int nr = cur.r + dr[d];
				int nc = cur.c + dc[d];
				try {
					if(cur.color == map[nr][nc] && !visited[nr][nc]) {
						q.add(new RGB(map[nr][nc],nr,nc));
						visited[nr][nc] = true;
					}
				} catch (Exception e) {}
			}
		}
	}
	
	
	static void no_bfs(RGB rgb) {
		Queue<RGB> q = new LinkedList<>();
		q.add(rgb);
		visited[rgb.r][rgb.c] = true;
		
		while(!q.isEmpty()) {
			RGB cur = q.poll();
			for(int d = 0; d<4;d++) {
				int nr = cur.r + dr[d];
				int nc = cur.c + dc[d];
				try {
					if(cur.color == 'B') {
						if(cur.color == map[nr][nc] && !visited[nr][nc]) {
							q.add(new RGB(map[nr][nc],nr,nc));
							visited[nr][nc] = true;
						}
					} else if(cur.color == 'G' || cur.color == 'R') {
						if((map[nr][nc]=='G' || map[nr][nc] == 'R')&& !visited[nr][nc]) {
							q.add(new RGB(map[nr][nc],nr,nc));
							visited[nr][nc] = true;
						}
					}
				} catch (Exception e) {}
			}
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		visited = new boolean[N][N];
		
		for(int i = 0; i<N;i++) {
			String s = br.readLine();
			map[i] = s.toCharArray();
		}
		
		for(int i = 0 ;i<N;i++) {
			for(int j = 0 ;j<N;j++) {
				if(!visited[i][j]) {
					no_bfs(new RGB(map[i][j],i,j));
					nocnt++;
				}
			}
		}
		visited = new boolean[N][N];
		for(int i = 0 ;i<N;i++) {
			for(int j = 0 ;j<N;j++) {
				if(!visited[i][j]) {
					bfs(new RGB(map[i][j],i,j));
					cnt++;
				}
			}
		}
		System.out.println(cnt+" "+nocnt);
	} // end of main
} // end of class
