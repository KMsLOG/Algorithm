import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class Node{
    int r;
    int c;
    int h;

    public Node(int r, int c, int h){
        this.r = r;
        this.c = c;
        this.h = h;
    }
}
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        int[][][] map = new int[H][N][M];
        Queue<Node> q = new ArrayDeque<>();

        for(int h = 0 ; h<H;h++){
            for(int n = 0 ;n<N;n++){
                st = new StringTokenizer(br.readLine());
                for(int m = 0 ;m<M;m++){
                    int tomato = Integer.parseInt(st.nextToken());
                    map[h][n][m] = tomato;
                    if(tomato == 1){
                        q.add(new Node(n,m,h));
                    }
                }
            }
        }

        int[] dr = {1,-1,0,0,0,0};
        int[] dc = {0,0,1,-1,0,0};
        int[] dh = {0,0,0,0,1,-1};

        while(!q.isEmpty()){
            Node cur = q.poll();
            for(int d = 0 ; d<6 ;d++){
                int nr = cur.r + dr[d];
                int nc = cur.c + dc[d];
                int nh = cur.h + dh[d];

                if(rangeCheck(nr,N) || rangeCheck(nc,M) || rangeCheck(nh,H)) continue;

                if(map[nh][nr][nc]==0){
                    map[nh][nr][nc]= map[cur.h][cur.r][cur.c]+1;
                    q.add(new Node(nr,nc,nh));
                }
            }

        }

        System.out.println(findMax(map,H,M,N));

    } // end of main

    public static boolean rangeCheck(int num, int st){
        return num < 0 || num >= st;
    }

    public static int findMax(int[][][] map, int H, int M, int N){
        int max = 0;
        for(int h = 0 ; h<H;h++){
            for(int n = 0 ;n<N;n++){
                for(int m = 0 ;m<M;m++){
                    if(map[h][n][m]==0){
                        return -1;
                    }
                    if(map[h][n][m]>max){
                        max = map[h][n][m];
                    }
                }
            }
        }

        return max-1;
    }
} // end of class
