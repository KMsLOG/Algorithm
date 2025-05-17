import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int M;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = new int[]{1,-1,0,0};
    static int[] dy = new int[]{0,0,1,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];
        int[] start = new int[2];

        for(int i = 0 ; i<N;i++){
            String s = br.readLine();
            for(int j = 0; j<M;j++){
                if(s.charAt(j)=='O'){
                    map[i][j] = 0;
                } else if(s.charAt(j)=='P'){
                    map[i][j] = 2;
                } else if(s.charAt(j)=='I'){
                    start[0] = i;
                    start[1] = j;
                    visited[i][j] = true;
                } else{
                    map[i][j] = 3;
                }
            }
        }
        int cnt = bfs(start[0],start[1]);

        if(cnt == 0){
            System.out.println("TT");
        } else{
            System.out.println(cnt);
        }
    } // end of main

    static int bfs(int r, int c){
        int cnt = 0;
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{r,c});

        while(!q.isEmpty()){
            int[] cur = q.poll();
            for(int d = 0 ; d<4; d++){
                int nr = cur[0] + dx[d];
                int nc = cur[1] + dy[d];

                if(nr<0 || nr>=N || nc<0 || nc>=M) continue;

                if(map[nr][nc]<=2 && !visited[nr][nc]){
                    visited[nr][nc] = true;
                    if(map[nr][nc]==2) cnt++;
                    q.add(new int[]{nr,nc});
                }
            }
        }
        return cnt;
    }
} // end of class\

