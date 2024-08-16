import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

class Danji{
	int r;
	int c;
	public Danji(int r, int c) {
		this.r = r;
		this.c = c;
	}
	
}


public class Main {
	
	static int[][] map;
	static boolean[][] visited;
	static int cnt;
	static int size;
	static PriorityQueue<Integer> pq = new PriorityQueue<>();
	static int[] dr = {1,-1,0,0};
	static int[] dc = {0,0,1,-1};
	
	
	static void bfs(Danji start) {
		size = 1;
		Queue<Danji> q = new LinkedList<>();
		q.add(start);
		visited[start.r][start.c] = true;
		while(!q.isEmpty()) {
			Danji cur = q.poll();
			for(int d = 0 ;d<4;d++) {
				int nr = cur.r+dr[d];
				int nc = cur.c+dc[d];
				
				try {
					if(map[nr][nc] == 1 && !visited[nr][nc]) {
						q.add(new Danji(nr,nc));
						visited[nr][nc] = true;
						size++;
					}
				} catch (Exception e) {}
			}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];
		Queue<Danji> q = new LinkedList<>(); // 1인 집 큐
		
		
		for(int i = 0 ; i<N;i++) {
			String s = br.readLine();
			for(int j = 0 ; j<N;j++) {
				map[i][j] = s.charAt(j)-'0';
				if(map[i][j] == 1) {
					q.add(new Danji(i,j));
				}
			}
		}
		
		
		while(!q.isEmpty()) {
			Danji dan = q.poll();
			if(!visited[dan.r][dan.c]) {
				bfs(dan);
				cnt++;
				pq.add(size);
			}
			
		}
		
		System.out.println(cnt);
		while(!pq.isEmpty()) {
			System.out.println(pq.poll());
		}
	} // end of main
} // end of class
