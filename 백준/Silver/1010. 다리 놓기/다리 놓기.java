import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int[][] dp = new int[31][31];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            String[] tokens = br.readLine().split(" ");
            int R = Integer.parseInt(tokens[0]);
            int N = Integer.parseInt(tokens[1]);

            // 조합 개수 계산
            int result = combination(N, R);
            sb.append(result).append("\n");
        }
        System.out.print(sb);
    }

    static int combination(int n, int r) {
        
        if(dp[n][r]>0) {
        	return dp[n][r];
        } else if (n==r||r==0) {
        	return dp[n][r] = 1;
        } else {
        	return dp[n][r] = combination(n-1,r-1) + combination(n-1,r);
        }
    }
}
