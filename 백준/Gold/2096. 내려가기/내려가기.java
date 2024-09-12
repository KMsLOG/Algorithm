import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[]max_dp = new int[3];
		int[]min_dp = new int[3];
		
		for(int i = 0 ; i<N ;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] max_tmp = new int[3];
			int[] min_tmp = new int[3];
			
			int num1 = Integer.parseInt(st.nextToken());
			max_tmp[0] = num1 + Math.max(max_dp[0], max_dp[1]);
			min_tmp[0] = num1 + Math.min(min_dp[0], min_dp[1]);
			
			int num2 = Integer.parseInt(st.nextToken());
			max_tmp[1] = num2 + Math.max(max_dp[2],Math.max(max_dp[0], max_dp[1]));
			min_tmp[1] = num2 + Math.min(min_dp[2],Math.min(min_dp[0], min_dp[1]));
			
			int num3 = Integer.parseInt(st.nextToken());
			max_tmp[2] = num3 + Math.max(max_dp[2], max_dp[1]);
			min_tmp[2] = num3 + Math.min(min_dp[2], min_dp[1]);
			
			
			for(int t = 0 ;t<3;t++) {
				max_dp[t] = max_tmp[t];
				min_dp[t] = min_tmp[t];
			}
		}
		
		Arrays.sort(max_dp);
		Arrays.sort(min_dp);
		System.out.println(max_dp[2]+" "+min_dp[0]);
	} // end of main
} // end of class
