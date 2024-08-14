import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point {
	int r;
	int c;
	public Point(int r, int c) {
		this.r = r;
		this.c = c;
	}
	
}

public class Main {
	
	static int N; // N개의 행/열
	static int[] dr = {1,0,-1,0};
	static int[] dc = {0,-1,0,1};
	static boolean[][] safe;
	static boolean[][] visit;
	static int[][] map;
	static void dfs(int r, int c) {
		visit[r][c] = true;
		for(int d = 0; d<4;d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if(nr<0 || nr >=N || nc<0 ||nc>=N) {
				continue;
			}
			if(safe[nr][nc] == true && visit[nr][nc]==false) {
				dfs(nr,nc);
			}
		}
	}

	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
       
        int max_rain = 0;
        for(int i = 0 ;i<N;i++) {
        	String s = br.readLine();
        	StringTokenizer st = new StringTokenizer(s);
        	for(int j = 0 ; j<N;j++) {
        		map[i][j]= Integer.parseInt(st.nextToken());
        		if(max_rain<map[i][j]) {
        			max_rain = map[i][j];
        		}
        	}
        }
        
        int maxcnt = 0;
        
        // 여기까지 초기값 설정
        // 앞으로 해아야할거 반복문 돌릴 때 마다 safe / visit 초기화하기
        for(int rain = max_rain ; rain>=0;rain--) {
        	int cnt = 0;
        	safe = new boolean[N][N];
            visit = new boolean[N][N];
            Queue<Point> zones = new LinkedList<>();
        	
            
            for(int i = 0 ; i<N;i++) {
            	for(int j = 0 ;j<N;j++) {
            		if(map[i][j]>rain) {
            			safe[i][j] = true;
            			zones.add(new Point(i,j));
            		}
            	}
            }
            
            
            
            while(!zones.isEmpty()) {
            	Point cur = zones.poll();
            	if(visit[cur.r][cur.c] == false) {
            		dfs(cur.r,cur.c);
            		cnt++;
            	}
            }
            if(maxcnt < cnt) {
            	maxcnt =cnt;
            }
        }
        System.out.println(maxcnt);
	} // end of main
} // end of class
