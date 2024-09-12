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
        int[] coins = new int[N];
        for(int i = 0 ;i<N ;i++) {
        	coins[i] = Integer.parseInt(br.readLine());
        }
        System.out.println(count(coins, K));
    }
	
	public static int count(int[] coins, int k) {
        
        int[] dp = new int[k + 1];
        dp[0] = 1; 
        
        for (int coin : coins) {
            for (int i = coin; i <= k; i++) {
                dp[i] += dp[i - coin];
            }
        }
        
        return dp[k];
    } // end of count
} // end of class
