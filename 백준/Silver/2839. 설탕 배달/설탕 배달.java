import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int N;
    static int[] dp;
    static int[] move = {3, 5};

    static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        dp[start] = 0;  // 시작 위치의 dp 값을 0으로 초기화
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int d = 0; d < 2; d++) {
                int nx = cur + move[d];
                if (nx > N) continue; // N보다 큰 값은 필요 없음
                if (dp[nx] == -1) {  // 방문하지 않은 위치일 경우
                    dp[nx] = dp[cur] + 1;
                    if (nx == N) {
                        return;
                    }
                    q.add(nx);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            dp[i] = -1;  // 초기화
        }
        bfs(0);
        if (dp[N] == -1) {
            System.out.println(-1);
        } else {
            System.out.println(dp[N]);
        }
    } // end of main
} // end of class
