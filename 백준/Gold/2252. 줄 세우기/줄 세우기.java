import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb;
    static int N, M;
    static List<Integer>[] graph;
    static int[] degree;
    static Queue<Integer> q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 인접 리스트 초기화
        graph = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        
        degree = new int[N+1];
        q = new LinkedList<>();
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int small = Integer.parseInt(st.nextToken());
            int big = Integer.parseInt(st.nextToken());
            
            graph[small].add(big); // 인접 리스트에 추가
            degree[big]++;
        }

        for (int i = 1; i <= N; i++) {
            if (degree[i] == 0) {
                q.add(i);
            }
        }

        sort();
        System.out.print(sb);
    } // end of main
    
    static void sort() {
        while (!q.isEmpty()) {
            int size = q.size();
            for (int t = 0; t < size; t++) {
                int cur = q.poll();
                sb.append(cur + " ");
                for (int next : graph[cur]) {
                    degree[next]--;
                    if (degree[next] == 0) {
                        q.add(next);
                    }
                }
            }
        }
    } // end of sort
} // end of class
