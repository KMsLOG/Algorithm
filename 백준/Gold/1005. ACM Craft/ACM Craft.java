import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    
    static int[] cost;
    static int[] degree;
    static int[] dp;
    static List<Integer>[] graph;
    static Queue<Integer> q; 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        
        for (int tc = 0; tc < T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            
            cost = new int[N + 1];
            degree = new int[N + 1];
            dp = new int[N + 1];
            graph = new ArrayList[N + 1];
            
            for (int i = 1; i <= N; i++) {
                graph[i] = new ArrayList<>();
            }
            
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                cost[i] = Integer.parseInt(st.nextToken());
                dp[i] = cost[i];
            }
            
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int pre = Integer.parseInt(st.nextToken());
                int post = Integer.parseInt(st.nextToken());
                
                graph[pre].add(post);
                degree[post]++;
            }
            q = new LinkedList<>();
            for (int i = 1; i <= N; i++) {
                if (degree[i] == 0) {
                    q.add(i);
                }
            }
            
            sort();
            
            int W = Integer.parseInt(br.readLine());
            sb.append(dp[W]+"\n");
        } // end of tc
        
        System.out.print(sb);
    } // end of main
    
    static void sort() {
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int next : graph[cur]) {
                dp[next] = Math.max(dp[next], dp[cur] + cost[next]);
                degree[next]--;
                
                if (degree[next] == 0) {
                    q.add(next);
                }
            }
        }
    } // end of sort
} // end of class
