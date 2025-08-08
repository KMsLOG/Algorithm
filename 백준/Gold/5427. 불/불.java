import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.*;

class Node{
    int r;
    int c;
    boolean fire;
    public Node(int r, int c, boolean fire){
        this.r = r;
        this.c = c;
        this.fire = fire;
    }
}

public class Main {
    static Queue<Node> q;
    static boolean[][] visited;
    static int[][] escape;
    static int w;
    static int h;
    static int[] dr = {0,0,-1,1};
    static int[] dc = {1,-1,0,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int t = 0 ; t<T ;t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            q = new ArrayDeque<>();

            visited = new boolean[h][w];
            escape = new int[h][w];
            int[] sg = new int[2];
            for(int i = 0 ;i<h ;i++){
                String s = br.readLine();
                for(int j = 0 ; j<w ;j++){
                    char c = s.charAt(j);
                    if(c == '#'){
                        visited[i][j] = true;
                    } else if(c == '*'){
                        q.add(new Node(i,j,true));
                        visited[i][j]  = true;
                    } else if(c == '@'){
                        sg[0] = i;
                        sg[1] = j;
                        escape[i][j] = 1;
                    }
                }
            }

            q.add(new Node(sg[0],sg[1],false));

            int result = bfs();

            if(result==-1) sb.append("IMPOSSIBLE\n");
            else{
                sb.append(result).append("\n");
            }
        } // end of tc

        System.out.println(sb);
    } // end of main

    static int bfs(){
        while(!q.isEmpty()){
            Node cur = q.poll();

            // 불이면
            if(cur.fire){
                for(int d = 0 ; d<4 ; d++){
                    int nr = cur.r+dr[d];
                    int nc = cur.c+dc[d];

                    if(nr>=h || nr<0 || nc>=w || nc<0) continue;

                    if(!visited[nr][nc]){
                        visited[nr][nc] = true;
                        q.add(new Node(nr,nc,true));
                    }
                }
            }

            // 상근이면
            else {
                for(int d = 0 ; d<4 ; d++){
                    int nr = cur.r+dr[d];
                    int nc = cur.c+dc[d];

                    if(nr>=h || nr<0 || nc>=w || nc<0){
                        return escape[cur.r][cur.c];
                    }

                    if(escape[nr][nc]==0 && !visited[nr][nc]){
                        escape[nr][nc] = escape[cur.r][cur.c] + 1;
                        q.add(new Node(nr,nc,false));
                    }
                }
            }
        }
        return -1;
    }
} // end of class
