import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static List<Integer>[] arr;
    static int[] cnt;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new ArrayList[N + 1];
        cnt = new int[N + 1];
        
        for (int i = 1; i <= N; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int child = Integer.parseInt(st.nextToken());
            int parent = Integer.parseInt(st.nextToken());
            arr[child].add(parent);
        }

        for (int i = 1; i <= N; i++) {
            visited = new boolean[N + 1];
            dfs(i);
        }

        int maxCnt = 0;
        for (int i = 1; i <= N; i++) {
            maxCnt = Math.max(maxCnt, cnt[i]);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if (cnt[i] == maxCnt) {
                sb.append(i).append(" ");
            }
        }

        System.out.print(sb);
    } // end of main

    static void dfs(int node) {
        visited[node] = true;
        for (int next : arr[node]) {
            if (!visited[next]) {
                cnt[next]++;
                dfs(next);
            }
        }
    } // end of dfs
} // end of class