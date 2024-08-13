import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_2001_파리퇴치_D2_조강민_111ms {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
			for(int testcase = 0 ; testcase<T;testcase++) {
			String[] nm = br.readLine().split(" ");
			
			int N = Integer.parseInt(nm[0]);
			int M = Integer.parseInt(nm[1]);
			int maxsum = 0;
			int[][] flies = new int[N][N];
			for(int i =0 ; i<N;i++) {
				String s = br.readLine();
				StringTokenizer st = new StringTokenizer(s);
				for(int j = 0 ; j<N;j++) {
					flies[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for(int i = 0 ; i<=N-M;i++) {
				for(int j = 0 ; j<=N-M;j++) {
					int sum = 0;
					for(int n = 0; n<M;n++) {
						for(int m = 0; m<M;m++) {
							sum+=flies[i+n][j+m];
						}
					}
					maxsum = Math.max(maxsum, sum);
				}
			}
			
			sb.append("#").append(testcase+1).append(" ").append(maxsum).append("\n");
		} // end of testcse
		System.out.print(sb);
	} // end of main
} // end of class
