import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		dp = new int[N+1];
		
		for(int i = 1 ; i<=N ;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int cost = Integer.parseInt(st.nextToken());
			int cnt = Integer.parseInt(st.nextToken());
			if(cnt == 0) {
				dp[i] = cost;
			}
			for(int j = 0 ;j<cnt;j++) {
				int pre = Integer.parseInt(st.nextToken());
				dp[i] = Math.max(dp[i], dp[pre]+cost);
			}
			
		}

		Arrays.sort(dp);
		
		System.out.println(dp[dp.length-1]);
	} // end of main
} // end of class
