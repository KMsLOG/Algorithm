import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static boolean[][] visited;
    static int[][] map;
    static int N,M;
    static int[] dr = {0,0,-1,1};
    static int[] dc = {1,-1,0,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        int cheeseCnt = 0;
        // 맵 값 넣기
        for(int i = 0 ; i<N ;i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ;j<M ; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==1){
                    cheeseCnt++;
                }
            }
        }

        int time = 0;

        //루프 시작
        while(cheeseCnt>0){
            visited = new boolean[N][M];
            air();
            Queue<int[]> q = new ArrayDeque<>();
            for(int i = 0 ;i<N;i++){
                for(int j = 0 ;j<M;j++){
                    if(map[i][j]==1){
                        if(cheeseCheck(i,j)) q.add(new int[]{i,j});
                    }
                }
            }
            cheeseCnt -= q.size();
            while(!q.isEmpty()){
                int[] cur = q.poll();
                map[cur[0]][cur[1]]= 0;
            }
            time++;
        }
        System.out.println(time);
    } // end of main

    // 공기 접촉
    static void air(){
        visited[0][0] = true;
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{0,0});
        while(!q.isEmpty()){
            int[] cur = q.poll();
            for(int i = 0 ;i<4;i++){
                int nr = cur[0]+dr[i];
                int nc = cur[1]+dc[i];
                if(nr<0 || nr>=N || nc<0 || nc>=M) continue;
                if(!visited[nr][nc]&&map[nr][nc]==0){
                    visited[nr][nc] = true;
                    q.add(new int[]{nr,nc});
                }
            }
        }
    } // end of air

    // 치즈 체크
    static boolean cheeseCheck(int r, int c){
        int airCnt = 0;
        for(int i = 0 ;i<4;i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
            if (visited[nr][nc] && map[nr][nc] == 0) {
                airCnt++;
            }
        }
        return airCnt >= 2;
    } // end of cheeseCheck
} // end of class
