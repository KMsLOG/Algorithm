import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static List<Integer>[] arr;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new ArrayList[N + 1];
        dp = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            arr[i] = new ArrayList<>();
        }
        
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int sen = Integer.parseInt(st.nextToken());
            if (sen == -1) {
                continue;
            }
            arr[sen].add(i);
        }
        
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int sen = Integer.parseInt(st.nextToken());
            int good = Integer.parseInt(st.nextToken());
            
            dp[sen] +=good;
        }
        
        
        dfs(1);
        
        for (int i = 1; i <= N; i++) {
            System.out.print(dp[i] + " ");
        }
    } // end of main
    
    static void dfs(int start) {
    	for(int i : arr[start]) {
    			dp[i] = dp[i]+dp[start];
    			dfs(i);
    	}
        
    } // end of dfs
} // end of class
