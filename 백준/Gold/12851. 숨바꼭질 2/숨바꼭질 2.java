import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        if (N == K) {
            System.out.println(0);
            System.out.println(1);
            return;
        }

        int[] result = findFast(N, K);
        System.out.println(result[0]);
        System.out.println(result[1]);
    }

    static int[] findFast(int N, int K) {
        int[] result = new int[2];
        int[] cnt = new int[100001]; // 경로 수 배열
        int[] dist = new int[100001]; // 거리 배열

        Queue<Integer> q = new ArrayDeque<>();
        q.add(N);
        cnt[N] = 1; // 시작 위치의 경로 수
        dist[N] = 0; // 시작 위치의 거리

        while (!q.isEmpty()) {
            int cur = q.poll();

            // 현재 위치에서 가능한 이동
            int[] nextMoves = {cur * 2, cur + 1, cur - 1};

            for (int next : nextMoves) {
                if (next < 0 || next > 100000) continue; // 범위 체크

                // 처음 방문하는 경우
                if (dist[next] == 0 && next != N) {
                    dist[next] = dist[cur] + 1;
                    cnt[next] = cnt[cur]; // 경로 수 갱신
                    q.add(next);
                } else if (dist[next] == dist[cur] + 1) {
                    cnt[next] += cnt[cur]; // 경로 수 추가
                }
            }
        }

        // 결과 설정
        result[0] = dist[K];
        result[1] = cnt[K];
        return result;
    }
}
