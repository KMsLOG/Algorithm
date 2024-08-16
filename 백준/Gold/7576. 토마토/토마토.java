import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


class Tomato{
	int r;
	int c;
	public Tomato(int r, int c) {
		this.r = r;
		this.c = c;
	}
}

public class Main {
	static int R,C;
	static int[][] box;
	static int[] dr = {1,-1,0,0};
	static int[] dc = {0,0,1,-1};
	static int cnt = 0;
	static Queue<Tomato> q = new LinkedList<>();
	static int cccc = 0;
	static int bfs() {
		while(!q.isEmpty()) {
			Tomato cur = q.poll();
			for(int d = 0 ; d<4;d++) {
				int nr = cur.r+dr[d];
				int nc = cur.c+dc[d];
				
				if(nr>=0 && nr<R && nc>=0 && nc<C && box[nr][nc]==0) {
					q.add(new Tomato(nr,nc));
					box[nr][nc] = box[cur.r][cur.c]+1;
				}
			}
		}
		
		for(int i = 0 ; i<R;i++) {
			for(int j =0 ; j<C;j++) {
				if(box[i][j] == 0) {
					return -1;
				}
				cnt = Math.max(cnt, box[i][j]);
			}
		}
		if (cnt == 1) {
            return 0;
        } else { // 아닐 경우 최종날짜 - 1 출력
            return cnt-1;
        }
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		C = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		box = new int[R][C];
		
		for(int i = 0 ; i<R;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j =0;j<C;j++) {
				box[i][j] = Integer.parseInt(st.nextToken());
				if(box[i][j] == 1) {
					q.add(new Tomato(i,j));
				}
			}
		}
		System.out.println(bfs());
	} // end of main
} // end of class
