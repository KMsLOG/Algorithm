import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] student;
    static boolean[] visited;
    static boolean[] finished;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            student = new int[N + 1];
            visited = new boolean[N + 1];
            finished = new boolean[N + 1];
            cnt = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                student[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 1; i <= N; i++) {
                if (!visited[i]) {
                    dfs(i);
                }
            }
            sb.append(N - cnt).append("\n");
        }
        System.out.print(sb);
    } // end of main

    static void dfs(int now) {
        visited[now] = true;
        int next = student[now];

        if (!visited[next]) {
            dfs(next);
        } else {
            if (!finished[next]) {
                cnt++;
                int i = next;
                while(i != now){
                    cnt++;
                    i = student[i];
                }
            }
        }
        finished[now] = true;
    } // end of dfs
} // end of class
