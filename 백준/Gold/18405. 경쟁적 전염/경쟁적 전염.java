import java.io.*;
import java.util.*;

public class Main {

    static int N,K;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    static class Virus {
        int r, c, num, time;
        public Virus(int r, int c, int num, int time) {
            this.r = r;
            this.c = c;
            this.num = num;
            this.time = time;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][N];
        List<Virus> list = new ArrayList<>();
        for(int i = 0 ; i<N ;i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ;j<N ;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                list.add(new Virus(i,j,map[i][j],0));
            }
        }

        list.sort((a, b) -> a.num - b.num);

        Queue<Virus> q = new ArrayDeque<>();
        q.addAll(list);

        st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());
        while(!q.isEmpty()){
            Virus cur = q.poll();

            for(int d = 0 ; d<4; d++){
                int nr = cur.r+dr[d];
                int nc = cur.c+dc[d];

                if (nr < 0 || nc < 0 || nr >= N || nc >= N) continue;

                if(map[nr][nc]==0 && cur.time<S){
                    map[nr][nc] = cur.num;
                    q.offer(new Virus(nr,nc,cur.num,cur.time+1));
                }
            }
        }

        System.out.println(map[X-1][Y-1]);
    }
}
