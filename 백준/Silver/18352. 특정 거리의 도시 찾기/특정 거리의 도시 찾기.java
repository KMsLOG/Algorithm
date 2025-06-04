import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] arr = new ArrayList[N+1];
        int[] cost = new int[N+1];
        Arrays.fill(cost,Integer.MAX_VALUE);
        for(int i =0 ;i<N+1;i++){
            arr[i] = new ArrayList<>();
        }

        for(int i = 0 ; i<M;i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            arr[start].add(end);
        }

        cost[X] = 0;

        Queue<Integer> q = new ArrayDeque<>();
        q.add(X);
        while(!q.isEmpty()){
            int cur = q.poll();
            for(int next : arr[cur]){
                if(cost[next]<cost[cur]+1) continue;
                cost[next] = cost[cur]+1;
                q.add(next);
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        for(int i = 0 ; i<N+1;i++){
            if(cost[i]==K){
                result.add(i);
            }
        }

        if(result.isEmpty()){
            System.out.println(-1);
        } else{
            for(int r : result){
                System.out.println(r);
            }
        }
    } // end of main
} // end of class
