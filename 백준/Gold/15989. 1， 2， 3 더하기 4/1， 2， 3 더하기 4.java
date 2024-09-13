import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
	public static void main(String[] args) throws  IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int tc = 0 ;tc<T ;tc++) {
			int num = Integer.parseInt(br.readLine());
			
			int[] dp = new int[num+1];
			dp[0] = 1;
			for(int i = 1 ;i<=3;i++) {
				for(int j = i ; j<=num;j++) {
					dp[j]+=dp[j-i];
				}
			}
			
			sb.append(dp[num]+"\n");
		}
		System.out.print(sb);
	} // end of main
} // end of class
