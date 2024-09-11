import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Fish implements Comparable<Fish>{
	int r;
	int c;
	int dist;
	public Fish(int r, int c, int dist) {
		this.r = r;
		this.c = c;
		this.dist = dist;
	}
	@Override
	public int compareTo(Fish o) {
		if(this.dist == o.dist) {
			if(this.r == o.r) {
				return this.c -o.c;
			}
			return this.r-o.r;
		}
		return this.dist-o.dist;
	}
}

class Shark{
	int r;
	int c;
	int size;
	int eaten;
	public Shark(int r, int c, int size, int eaten) {
		this.r = r;
		this.c = c;
		this.size = size;
		this.eaten = eaten;
	}
}


public class Main {
	static int N;
	static int[][] map;
	static boolean[][] visited;
	static Shark shark;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		
		for(int i = 0 ; i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 9) {
					shark = new Shark(i,j,2,0);
					map[i][j] = 0;
				}
			}
		}
		
		int total = 0;
		
		while(true) {
			int dist = bfs(shark.r,shark.c);
			if(dist == 0) {
				break;
			}
			total+=dist;
		}
		System.out.println(total);
	} // end of main
	
	static int bfs(int r, int c) {
		Queue<Fish> q = new LinkedList<>(); // 상어 움직이는 큐
		PriorityQueue<Fish> pq = new PriorityQueue<>(); // 먹잇감 넣는 우선순위 큐
		visited = new boolean[N][N];
		
		q.add(new Fish(r,c,0));
		visited[r][c] = true;
		while(!q.isEmpty()) {
			int size = q.size();
			for(int s = 0 ;s<size;s++) {
				Fish cur = q.poll();
				for(int d = 0 ;d<4;d++) {
					int nr = cur.r+dr[d];
					int nc = cur.c+dc[d];
					try {
						if(!visited[nr][nc] && map[nr][nc]<=shark.size) { // 이동 가능하면
							visited[nr][nc] = true;
							q.add(new Fish(nr,nc,cur.dist+1));
						}
						if(map[nr][nc]<shark.size && map[nr][nc]!=0) { // 먹잇감이 존재하면
							pq.add(new Fish(nr,nc,cur.dist+1));
						}
					} catch (Exception e) {}
				}
			}
			if(!pq.isEmpty()) { // 먹잇감이 존재하면
				break; // 반복문 종료
			}
		}
		int dist = 0;
		if(!pq.isEmpty()) {
			Fish target = pq.poll();
			shark.r = target.r; // 상어 위치 먹잇감 위치로
			shark.c = target.c;
			dist = target.dist; // 먹잇감과의 거리
			map[target.r][target.c] = 0; // 먹음
			shark.eaten++; // 상어가 잡아먹은 물고기 수 ++
			if(shark.size == shark.eaten) { // 상어 크기와 잡아먹은 물고기 수가 같다면
				shark.size++; // 사이즈 업
				shark.eaten=0; // 잡아먹은 물고기 수 초기화
			}	
		}
		return dist;
	} // end of bfs
} // end of class
