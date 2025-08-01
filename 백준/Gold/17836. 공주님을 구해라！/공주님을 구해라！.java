import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class Node {
    int r;
    int c;
    boolean isGram;
    int time;

    public Node(int r, int c, boolean isGram, int time){
        this.r = r;
        this.c = c;
        this.isGram = isGram;
        this.time = time;
    }
}

public class Main {
    static int N, M, T;
    static int[][] map;
    static boolean[][][] visited;
    static int[] dr = {0, 0, -1, 1};
    static int[] dc = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[2][N][M];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = bfs();
        if(result==-1){
            System.out.println("Fail");
        } else {
            System.out.println(result);
        }
    } // end of main

    static int bfs(){
        Queue<Node> q = new ArrayDeque<>();
        q.add(new Node(0, 0, false, 0));
        visited[0][0][0] = true;

        while(!q.isEmpty()){
            Node cur = q.poll();

            if(cur.r == N-1 && cur.c == M-1){
                return cur.time;
            }

            if(cur.time >= T) continue;

            for(int d = 0; d < 4; d++){
                int nr = cur.r + dr[d];
                int nc = cur.c + dc[d];

                if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue;

                if(map[nr][nc] == 0){
                    int gramState = 0;
                    if(cur.isGram){
                        gramState = 1;
                    }
                    if(!visited[gramState][nr][nc]){
                        visited[gramState][nr][nc] = true;
                        q.add(new Node(nr, nc, cur.isGram, cur.time + 1));
                    }
                }

                // 그람 만날때
                else if(map[nr][nc] == 2){
                    if(!visited[1][nr][nc]){
                        visited[1][nr][nc] = true;
                        q.add(new Node(nr, nc, true, cur.time + 1));
                    }
                }
                // 그람 사용할 때
                else if(map[nr][nc] == 1 && cur.isGram){
                    if(!visited[1][nr][nc]){
                        visited[1][nr][nc] = true;
                        q.add(new Node(nr, nc, true, cur.time + 1));
                    }
                }
            }
        }
        return -1;
    } // end of bfs
} // end of class