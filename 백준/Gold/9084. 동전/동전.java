import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static int[] money;
	static int[] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc<=T ;tc++) {
			N = Integer.parseInt(br.readLine());
			money = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0 ;i <N;i++) {
				money[i] = Integer.parseInt(st.nextToken());
			}
			M = Integer.parseInt(br.readLine());
			dp = new int[M+1];
			dp[0] = 1;
			
			for(int mon : money) {
				for(int i = mon ; i<=M ; i++) {
					dp[i] +=dp[i-mon];
				}
			}
			sb.append(dp[M]+"\n");
		} // end of tc
		System.out.print(sb);
	} // end of main
} // end of class
