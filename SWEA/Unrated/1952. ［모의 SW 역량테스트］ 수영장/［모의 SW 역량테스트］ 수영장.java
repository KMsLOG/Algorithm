import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int tc =1 ;tc<=T ;tc++) {
			int[] price = new int[4];
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			// 이용권 가격
			for(int i = 0 ; i<4;i++) {
				price[i] = Integer.parseInt(st.nextToken());
			}
			
			// 1년 이용계획
			int[] health = new int[13];
			st = new StringTokenizer(br.readLine());
			for(int i = 1 ; i<=12;i++) {
				health[i] = Integer.parseInt(st.nextToken());
			}
			
			// dp
			int[] dp = new int[13];
			
			Arrays.fill(dp, Integer.MAX_VALUE);
			dp[0] = 0;
			for(int i = 1 ; i<=12;i++) {
				for(int c = 0; c<4 ; c++) {
					if(c ==0) { // 1일권
						dp[i] = Math.min(dp[i], dp[i-1] + price[c] * health[i]);
					} else if(c==1) { // 한달권
						dp[i] = Math.min(dp[i], dp[i-1] + price[c]);
					} else if(c==2) { // 3달권
						if(i>=3) {
							dp[i] = Math.min(dp[i], dp[i-3]+price[c]);
						} else {
							dp[i] = Math.min(dp[i], dp[0] +price[c]);
						}
					} else {
						dp[i] = Math.min(dp[i], price[c]);
					}
				}
			}
			
			sb.append("#"+tc+" "+dp[12]+"\n");
			
		} // end of tc
		System.out.print(sb);
	} // end of main
} // end of class
