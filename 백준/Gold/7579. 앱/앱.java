import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] memory = new int[N];
		int[] cost = new int[N];
		int[][] dp = new int[N][10001];
		int minC = Integer.MAX_VALUE;
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ;i<N ;i++) {
			memory[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ;i<N ;i++) {
			cost[i] = Integer.parseInt(st.nextToken());
		}
		
		
		for (int i = 0; i < N; i++) {
		    int c = cost[i];
		    int m = memory[i];

		    for (int j = 0; j <= 10000; j++) {
		        if (i == 0) { // 0번째 앱은 j >= cost만 확인한다!
		            if (j >= c) dp[i][j] = m;
		        } else {
		            if (j >= c) {
		                dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - c] + m);
		            } else {
		                dp[i][j] = dp[i - 1][j];
		            }
		        }
		        if (dp[i][j] >= M) {
		            minC = Math.min(minC, j);
		        }
		    }
		}
		
		System.out.println(minC);
	} // end of main
} // end of class
