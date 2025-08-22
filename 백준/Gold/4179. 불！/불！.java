import java.io.*;
import java.util.*;
class Node{
    int r;
    int c;
    boolean jihoon;
    int cnt;
    public Node(int r, int c, boolean jihoon, int cnt){
        this.r = r;
        this.c = c;
        this.jihoon = jihoon;
        this.cnt = cnt;
    }
}
public class Main {
    static int R,C;
    static boolean[][] visited;
    static int[] dr = {0,0,-1,1};
    static int[] dc = {-1,1,0,0};
    static Queue<Node> q;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        visited = new boolean[R][C];
        int[] jihoon = new int[2];
        q = new ArrayDeque<>();

        for(int i = 0 ;i<R;i++){
            String s = br.readLine();
            for(int j = 0 ; j<C ;j++){
                char c = s.charAt(j);
                if(c == '#'){
                    visited[i][j] = true;
                } else if(c=='J'){
                    jihoon[0] = i;
                    jihoon[1] = j;
                } else if(c=='F'){
                    visited[i][j]=true;
                    q.add(new Node(i,j,false,-1));
                }
            }
        }
        q.add(new Node(jihoon[0],jihoon[1],true,1));
        int result = bfs();

        if(result==-1){
            System.out.println("IMPOSSIBLE");
        } else{
            System.out.println(result);
        }
    } // end of main

    static int bfs(){
        while(!q.isEmpty()){
            Node cur = q.poll();

            for(int d = 0 ;d<4;d++){
                int nr = cur.r+dr[d];
                int nc = cur.c+dc[d];

                // 지훈일 경우
                if(cur.jihoon){
                    if(nr<0 || nr>=R || nc<0 || nc>=C){
                        return cur.cnt;
                    }
                    if(!visited[nr][nc]){
                        visited[nr][nc] = true;
                        q.add(new Node(nr,nc,true,cur.cnt+1));
                    }
                } else{ // 불일 경우
                    if(nr<0 || nr>=R || nc<0 || nc>=C) continue;
                    if(!visited[nr][nc]){
                        visited[nr][nc] = true;
                        q.add(new Node(nr,nc,false,cur.cnt));
                    }
                }
            }
        }
        return -1;
    } // end of bfs
} // end of class