import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<ArrayList<Integer>> graph;
    static int N,M;
    static int min = Integer.MAX_VALUE;
    static int ans = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();

        for(int i = 0 ; i<=N ;i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0 ; i<M ;i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            graph.get(A).add(B);
            graph.get(B).add(A);
        }

        for(int i= 1 ;i<=N;i++){
            bfs(i);
        }

        System.out.println(ans);
    } // end of main
    static void bfs(int start){
        Queue<int[]> q = new ArrayDeque<>();
        boolean[] visited = new boolean[N+1];
        q.add(new int[]{start,0});
        visited[start] = true;
        int result = 0;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            for(int next : graph.get(cur[0])){
                if(!visited[next]){
                    result+=cur[1]+1;
                    visited[next] = true;
                    q.add(new int[]{next,cur[1]+1});
                }
            }
        }

        if(result<min){
            min = result;
            ans = start;
        }
    } // end of bfs
}
