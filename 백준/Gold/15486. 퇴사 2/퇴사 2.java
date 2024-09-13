import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] time = new int[N + 1];
        int[] rev = new int[N + 1];
        int[] dp = new int[N + 2];
        int max = 0;
       
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());
            rev[i] = Integer.parseInt(st.nextToken());
        }

        
        for (int i = 1; i <= N; i++) {
            // 이전 날까지의 최대 수익을 현재 날로 이어받기
            dp[i + 1] = Math.max(dp[i + 1], dp[i]);
            // 현재 상담이 끝나는 날이 범위 내일 경우, 수익 계산
            if (i + time[i] <= N + 1) {
                dp[i + time[i]] = Math.max(dp[i + time[i]], dp[i] + rev[i]);
                max = Math.max(dp[i+time[i]], max);
            }
           
        }

        System.out.println(max);
    } // end of main
} // end of class
