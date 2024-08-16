import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Square{
	int r;
	int c;
	public Square(int r, int c) {
		this.r = r;
		this.c = c;
	}
}

public class Main {
	static int R,C,K;
	static boolean[][] map;
	static boolean[][] visited;
	static int cnt = 0;
	static int[] dr = {1,-1,0,0};
	static int[] dc = {0,0,1,-1};
 	static int size;
	static void dfs(Square sqr) {
		size = 1;
		Queue<Square> q = new LinkedList<>();
		q.add(sqr);
		visited[sqr.r][sqr.c] = true;
		while(!q.isEmpty()) {
			Square cur = q.poll();
			for(int d= 0 ; d<4;d++) {
				int nr = cur.r+dr[d];
				int nc = cur.c+dc[d];
				try {
					if(!visited[nr][nc] && !map[nr][nc]) {
						q.add(new Square(nr,nc));
						visited[nr][nc] = true;
						size++;
					}
				} catch (Exception e) {}
			}
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String rck = br.readLine();
		StringTokenizer st = new StringTokenizer(rck);
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		Queue<Square> q = new LinkedList<>();
		
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new boolean[R][C];
		visited = new boolean[R][C];
		
		for(int t = 0 ; t<K; t++) {
			st = new StringTokenizer(br.readLine());
			int y1 = Integer.parseInt(st.nextToken());
			int x1 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken())-1;
			int x2 = Integer.parseInt(st.nextToken())-1;
			
			for(int i = x1; i<=x2;i++) {
				for(int j = y1;j<=y2;j++) {
					map[i][j] = true;
				}
			}
		}
		for(int i = 0 ; i < R ; i++) {
			for(int j = 0 ; j< C ;j++) {
				if(!map[i][j]) {
					q.add(new Square(i,j));
				}
			}
		}
		while(!q.isEmpty()) {
			Square sqr = q.poll();
			if(!visited[sqr.r][sqr.c]) {
				dfs(sqr);
				cnt++;
				pq.add(size);
			}
		}
		
		
		System.out.println(cnt);
		while(!pq.isEmpty()) {
			System.out.print(pq.poll()+" ");
		}
	} // end of main
} // end of class
