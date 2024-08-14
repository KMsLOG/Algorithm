import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String cr = br.readLine();
		st = new StringTokenizer(cr);
		int C = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(br.readLine());
		
		if(C*R < K) {
			System.out.println(0);
		} else {
			int[][] hall = new int[R][C];
			int[] dr = {-1,0,1,0}; // 위 오른 아래 왼
			int[] dc = {0, 1, 0 ,-1};
			int r = R-1;
			int c = 0;
			int d = 0;
			int num = 1;
			while(num<K) {
				hall[r][c] = num;
				int nr = r + dr[d];
				int nc = c + dc[d];
				if(nr>R-1 || nr<0 || nc>C-1||nc<0||hall[nr][nc]!=0) {
					d = (d+1)%4;
				}
				r += dr[d];
				c += dc[d];
				num++;
			}
			System.out.println((c+1)+" "+(R-r));
		}
	} // end of main
} // end of class
