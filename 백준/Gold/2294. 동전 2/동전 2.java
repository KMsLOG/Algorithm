import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        int[] coins = new int[N];
        boolean[] visited = new boolean[K + 1]; // Array to track visited sums
        Queue<Integer> q = new ArrayDeque<>(); // Queue for BFS
        
        // Read coin denominations
        for (int i = 0; i < N; i++) {
            int coin = Integer.parseInt(br.readLine());
            coins[i] = coin;
            // Check if coin is within the valid range
            if (coin <= K) {
                visited[coin] = true; // Mark coin as visited
                q.add(coin); // Add coin to the queue
            }
        }
        
        // BFS initialization
        int cnt = 0;
        boolean found = false;
        
        while (!q.isEmpty()) {
            int size = q.size();
            cnt++;
            
            for (int s = 0; s < size; s++) {
                int cur = q.poll();
                if (cur == K) {
                    found = true;
                    break;
                }
                
                // Explore new sums
                for (int coin : coins) {
                    int next = cur + coin;
                    if (next <= K && !visited[next]) {
                        visited[next] = true;
                        q.add(next);
                    }
                }
            }
            
            if (found) break;
        }
        
        // Output the result
        if (found) {
            System.out.println(cnt);
        } else {
            System.out.println(-1);
        }
    } // end of main
} // end of class
