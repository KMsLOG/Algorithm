import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class Vac{
	int Num;
	int r;
	int c;
	int size;
	int d;
	public Vac(int Num, int r, int c, int size, int d) {
		super();
		this.Num = Num;
		this.r = r;
		this.c = c;
		this.size = size;
		this.d = d;
	}
}

public class Solution {
	static int N,M,K;
	static List<Integer>[][] map;
	static Queue<Vac> q;
	static int[] dr = {0,-1,1,0,0};
	static int[] dc = {0,0,0,-1,1};
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1 ;tc<=T ;tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			map = new ArrayList[N][N];
			
			for(int i = 0 ;i<N;i++) {
				for(int j = 0 ; j<N;j++) {
					map[i][j] = new ArrayList<>();
				}
			}
			
			q = new LinkedList<>();
			
			for(int i = 1 ; i <=K ;i++) {
				st = new StringTokenizer(br.readLine());
				int r = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				int size = Integer.parseInt(st.nextToken());
				int d = Integer.parseInt(st.nextToken());
				q.add(new Vac(i, r, c, size, d));
				map[r][c].add(i);
			}
			
			for(int i = 0 ; i<M;i++) {
				move();
				searchVac();
			}
			
			int total = 0;
			while(!q.isEmpty()) {
				total+=q.poll().size;
			}
			
			sb.append("#"+tc+" "+total+"\n");
		} // end of tc
		System.out.print(sb);
	} // end of main
	
	static void move() {
		int size = q.size();
		for(int i = 0 ;i<size;i++) {
			Vac cur = q.poll();
			
			int nr = cur.r+dr[cur.d];
			int nc = cur.c+dc[cur.d];
			try {
				// 약에 발라진 경우
				if(nr ==0 || nr == N-1 || nc == 0 || nc == N-1) {
					q.add(new Vac(cur.Num, nr, nc, cur.size/2, changeD(cur.d)));
				} else if(nr<N-1 || nr > 0 || nc < N-1 || nc > 0) {
					q.add(new Vac(cur.Num, nr, nc, cur.size, cur.d));
				}
				
				if(((nr ==0 || nr == N-1 || nc == 0 || nc == N-1) && cur.size/2>0) || (nr<N-1 || nr > 0 || nc < N-1 || nc > 0 )){
					map[nr][nc].add(cur.Num);
				}
				
				if(map[cur.r][cur.c].size()==1) {
					map[cur.r][cur.c].remove(0);
				} else { // 좌표에 여러개 있는 경우
					for(int j = 0 ;j<map[cur.r][cur.c].size();j++) {
						if(map[cur.r][cur.c].get(j) == cur.Num) {
							map[cur.r][cur.c].remove(j);
							break;
						}
					}
				}
			} catch (Exception e) {}
			
			
		}
	} // end of move
	
	static void searchVac() {
		for(int i = 0 ;i<N;i++) {
			for(int j = 0 ; j<N;j++) {
				if(map[i][j].size()>1) { // 좌표에 여러개가 만나면
					int sum = 0;
					int d = 0;
					int Num = 0;
					int max  = 0;
					
					for(int k = 0 ;k<map[i][j].size();k++) {
						while(!q.isEmpty()) {
							Vac v = q.poll();
							if(v.Num == map[i][j].get(k)) {
								sum+=v.size;
								if(max<v.size) {
									max = v.size;
									Num = v.Num;
									d = v.d;
								}
								break;
							} else {
								q.add(v);
							}
						}
					}
					q.add(new Vac(Num,i,j,sum,d));
					map[i][j].clear();
					map[i][j].add(Num);
				}
			}
		}
	} // searchVac
	
	static int changeD(int d) {
		switch (d) {
		case 1: return 2;
		case 2: return 1;
		case 3: return 4;
		case 4: return 3;
		
		}
		return 0;
	} // end of chageD
} // end of class
