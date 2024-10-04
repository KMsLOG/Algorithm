import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		long[][] dp = new long[K+1][N+1];
		
		for(int i = 0 ;i<=N;i++) {
			dp[1][i] = 1;
		}
		
		if(K>=2) {
			for(int i = 2; i<=K ;i++) {
				for(int j = 0; j<=N ; j++) {
					for(int k = 0 ; k<=j ;k++) {
						dp[i][j] += dp[i-1][k]%1000000000;
					}
					
				}
			}
		}
		System.out.println(dp[K][N]%1000000000);
	} // end of main
} // end of class
