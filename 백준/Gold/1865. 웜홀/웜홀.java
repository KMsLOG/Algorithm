import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

class Hall {
    int start;
    int end;
    int cost;
    public Hall(int start, int end, int cost) {
        this.start = start;
        this.end = end;
        this.cost = cost;
    }
}

public class Main {
    static int V, E, W;
    static ArrayList<Hall> arr;
    static final long INF = Long.MAX_VALUE;
    static long[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());

            arr = new ArrayList<>();
            dp = new long[V + 1];
            
            // 양방향 도로
            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());
                arr.add(new Hall(start,end,cost));
                arr.add(new Hall(end,start,cost));
            }

            // 단방향 웜홀
            for (int i = 0; i < W; i++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());
                arr.add(new Hall(start,end,-cost));
            }

            if (bellman()) {
                sb.append("YES\n");
            } else {
                sb.append("NO\n");
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static boolean bellman() {
    	dp = new long[V+1];
        boolean update =false;
        for (int t = 1; t <= V; t++) {
        	update =false;
            for (Hall cur : arr) {
            	if(dp[cur.start] == INF) {
            		continue;
            	}
                if (dp[cur.start] != INF && dp[cur.end] > dp[cur.start] + cur.cost) {
                    dp[cur.end] = dp[cur.start] + cur.cost;
                    update=true;
                }
            }
            if(!update) {
            	break;
            }
        }
        return update;
    }
}
