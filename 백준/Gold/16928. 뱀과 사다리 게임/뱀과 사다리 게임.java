import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static boolean[] visited = new boolean[101]; 
    static int[] board = new int[101]; 

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        
        // 보드에 사다리 등록
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            board[start] = end; 
        }
        
        // 보드에 뱀 등록
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            board[start] = end;
        }

        int cnt = bfs(1);

        System.out.println(cnt);
    } // end of main

    static int bfs(int start) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(start);
        visited[start] = true;

        int cnt = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int cur = q.poll();
                if (cur == 100) {
                    return cnt;
                }
                for (int dice = 1; dice <= 6; dice++) {
                    int next = cur + dice;
                    if (next > 100) continue; 

                    
                    if (board[next] != 0) {
                        next = board[next];
                    }

                    
                    if (!visited[next]) {
                        visited[next] = true;
                        q.add(next);
                    }
                }
            }
            cnt++;
        }

        return 0; 
    } // end of bfs
} // end of class
