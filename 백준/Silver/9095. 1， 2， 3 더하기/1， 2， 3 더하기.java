import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws  IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 0 ; tc<T;tc++) {
			int N = Integer.parseInt(br.readLine());
			
			int[] dp = new int[N+1];
			dp[0] = 1;
			for(int i = 0;i<=N;i++) {
				if(i>=1) {
					dp[i] += dp[i-1];
				}
				if(i>=2) {
					dp[i] += dp[i-2];
				}
				if(i>=3) {
					dp[i] += dp[i-3];
				}
				
			}
			
			sb.append(dp[N]+"\n");
			
		}
		System.out.print(sb);
	} // end of main
} // end of class
