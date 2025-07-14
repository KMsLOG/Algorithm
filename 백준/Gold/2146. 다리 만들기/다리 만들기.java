import javax.naming.BinaryRefAddr;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;
class Bridge{
    int r;
    int c;
    int br;

    public Bridge(int r, int c, int br){
        this.r = r;
        this.c = c;
        this.br = br;
    }
}
public class Main {

    static boolean[][] visited;
    static int[][] map;
    static int N;
    static int[] dr = {0,0,-1,1};
    static int[] dc = {1,-1,0,0};
    static int minBridge = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        map = new int[N][N];
        // 맵 값 넣기
        for(int i = 0 ; i<N ;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0 ;j<N ; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 섬 표시하기
        int color = -1;
        for(int i = 0 ; i<N;i++){
            for(int j = 0 ; j<N;j++){
                if(map[i][j]==1){
                    island(i,j,color);
                    color--;
                }
            }
        }
        // 최소 다리 길이 세기
        for(int i = 0 ; i<N;i++){
            for(int j = 0 ; j<N;j++){
                if(check(i,j)){
                    bridge(i,j,map[i][j]);
                }
            }
        }
        System.out.println(minBridge);
    } // end of main

    static boolean check(int r, int c){
        boolean flag = false;
        for(int d = 0 ; d<4 ; d++){
            int nr = r+dr[d];
            int nc = c+dc[d];

            if(nr<0 || nr>=N || nc<0 || nc>=N) continue;
            if(map[r][c]<0&&map[nr][nc]>=0){
                flag = true;
                break;
            }
        }
        return flag;
    }

    static void bridge(int r, int c, int startIsland){
        visited = new boolean[N][N];
        visited[r][c] = true;
        Queue<Bridge> q =  new ArrayDeque<>();
        q.add(new Bridge(r,c,0));

        while(!q.isEmpty()){
            Bridge cur = q.poll();
            for(int i = 0 ; i<4 ; i++){
                int nr = cur.r+dr[i];
                int nc = cur.c+dc[i];

                if(nr<0 || nr>=N || nc<0 || nc>=N) continue;
                if(map[nr][nc] != startIsland && map[nr][nc]<0){
                    if(cur.br < minBridge){
                        minBridge = cur.br;
                    }
                    break;
                }
                if(map[nr][nc]>=0 && cur.br <minBridge && !visited[nr][nc]){
                    visited[nr][nc] = true;
                    map[nr][nc] = cur.br;
                    q.add(new Bridge(nr,nc, cur.br+1));
                }
            }
        }

    } // end of bridge


    static void island(int r, int c, int color){
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{r,c});
        map[r][c] = color;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            for(int i = 0 ; i<4 ; i++){
                int nr = cur[0]+dr[i];
                int nc = cur[1]+dc[i];

                if(nr<0 || nr>=N || nc<0 || nc>=N) continue;
                if(map[nr][nc]==1){
                    map[nr][nc] = color;
                    q.add(new int[]{nr,nc});
                }
            }
        }
    } // end of island
} // end of class
