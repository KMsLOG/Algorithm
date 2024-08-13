import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_SWEA_1954_달팽이숫자_D2_조강민_117ms {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1 ; tc<=T;tc++) {
			System.out.println("#"+tc);
			int N = Integer.parseInt(br.readLine());
			int[][] arr = new int[N][N];
			int num = 1;
			int x = 0;
			int y = 0;
			int[] dx = {0,1,0,-1};// 동 남 서 북
			int[] dy = {1,0,-1,0};
			int d = 0;
			int nx;
			int ny;
			for(int i = 0; i<N*N+((int)Math.pow(2, N-1));i++) {
				arr[x][y] = num;
				nx = x+dx[d];
				ny = y+dy[d];
				if(nx>=0 && nx<N && ny>=0 && ny<N && arr[nx][ny]==0) {
					x= nx;
					y= ny;
					num++;
					
				} else {
					d=(d+1)%4;
			
				}

			}
			
			for(int[] list : arr) {
				for(int n : list) {
					System.out.print(n+" ");
				}
				System.out.println();
			}
		} // end of tc
		br.close();
	} // end of main
} // end of class
