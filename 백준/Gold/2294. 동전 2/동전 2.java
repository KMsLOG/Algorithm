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
        boolean[] visited = new boolean[K + 1];
        Queue<Integer> q = new ArrayDeque<>();
        
        // 코인 입력 및 초기화
        for (int i = 0; i < N; i++) {
            int coin = Integer.parseInt(br.readLine());
            coins[i] = coin;
            if (coin <= K) {
                if (!visited[coin]) {
                    visited[coin] = true;
                    q.add(coin);
                }
            }
        }
        
        int cnt = 0;
        boolean found = false;
        
        // BFS 수행
        while (!q.isEmpty()) {
            int size = q.size();
            cnt++;
            
            for (int s = 0; s < size; s++) {
                int cur = q.poll();
                if (cur == K) {
                    found = true;
                    break;
                }
                
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
        
        // 결과 출력
        if (found) {
            System.out.println(cnt);
        } else {
            System.out.println(-1);
        }
    }
}
