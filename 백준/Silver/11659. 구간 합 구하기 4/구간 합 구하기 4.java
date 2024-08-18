import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb= new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int[] dp = new int[N+1];
		for(int i = 1 ; i<N+1;i++) {
			dp[i] = dp[i-1]+Integer.parseInt(st.nextToken());
		}
		for(int i = 0 ; i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int startIdx = Integer.parseInt(st.nextToken());
			int endIdx = Integer.parseInt(st.nextToken());
			
			sb.append(dp[endIdx] - dp[startIdx-1] + "\n");
		}
		System.out.print(sb);
	} // end of main
} // end of class
