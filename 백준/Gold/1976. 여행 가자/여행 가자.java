import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        parents = new int[N+1];

        for(int i = 0 ; i<=N ;i++){
            parents[i] = i;
        }

        for(int i = 1; i<=N ;i++){
            st = new StringTokenizer(br.readLine());
            for(int n = 1 ;n<=N;n++){
                int city = Integer.parseInt(st.nextToken());
                if(city == 1){
                    union(i,n);
                }
            }
        }

        int[] plan = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ;i<M;i++){
            plan[i] = Integer.parseInt(st.nextToken());
        }
        boolean flag = true;
        for(int i = 0 ;i<M-1;i++){
            if(find(plan[i])!=find(plan[i+1])){
                flag = false;
                break;
            }
        }
        System.out.println(flag?"YES":"NO");
    } // end of main

    static void union(int n1, int n2){
        int a = find(n1);
        int b = find(n2);

        parents[a] = b;
    } // end of union

    static int find(int x){
        if(parents[x] == x){
            return x;
        }
        return parents[x] = find(parents[x]);
    } // end of find
} // end of class