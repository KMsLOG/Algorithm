import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[][] dp = new int[N][3];
		
		dp[0][0] = Integer.parseInt(st.nextToken());
		dp[0][1] = Integer.parseInt(st.nextToken());
		dp[0][2] = Integer.parseInt(st.nextToken());
		
		
		for(int i = 1 ; i<N;i++) {
			st = new StringTokenizer(br.readLine());
			dp[i][0] = Integer.parseInt(st.nextToken())+Math.min(dp[i-1][1], dp[i-1][2]);
			dp[i][1] = Integer.parseInt(st.nextToken())+Math.min(dp[i-1][0], dp[i-1][2]);
			dp[i][2] = Integer.parseInt(st.nextToken())+Math.min(dp[i-1][1], dp[i-1][0]);
		}
		
		
		System.out.println(Math.min(dp[N-1][0], Math.min(dp[N-1][1], dp[N-1][2])));
		
	} // end of main
} // end of class
