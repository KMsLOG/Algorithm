import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Time {
    int start;
    int end;
    int cost;

    public Time(int start, int end, int cost) {
        this.start = start;
        this.end = end;
        this.cost = cost;
    }
}

public class Main {
    static int V, E;
    static Time[] arr;
    static final long INF = Long.MAX_VALUE; 
    static long[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb= new StringBuilder();
        
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        arr = new Time[E];
        dp = new long[V + 1];
        Arrays.fill(dp, INF);

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            arr[i] = new Time(start, end, cost);
        }

        if (!bellmanFord(1)) {
            sb.append(-1);
        } else {
            for (int i = 2; i <= V; i++) {
                if (dp[i] == INF) {
                    sb.append(-1+"\n");
                } else {
                    sb.append(dp[i]+"\n");
                }
            }
        }
        System.out.print(sb);
    } // end of main

    static boolean bellmanFord(int start) {
        dp[start] = 0;

        // V-1번의 릴렉스 작업
        for (int i = 1; i <= V; i++) {
            for (Time time : arr) {
                if (dp[time.start] != INF && dp[time.start] + time.cost < dp[time.end]) {
                    dp[time.end] = dp[time.start] + time.cost;
                    
                    if(i ==V) {
                    	return false;
                    }
                }
            }
        }
        return true; // 음수 사이클이 없음
    } // end of bellman
} // end of class
