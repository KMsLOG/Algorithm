import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int G = Integer.parseInt(br.readLine());
        int P = Integer.parseInt(br.readLine());

        parents = new int[G+1];

        for(int i = 0 ; i<=G ;i++){
            parents[i] = i;
        }

        int cnt = 0;

        for(int i = 0 ; i<P ;i++){
            int gi = Integer.parseInt(br.readLine());
            if(find(gi)==0) break;
            union(find(gi),find(gi)-1);
            cnt++;
        }

        System.out.println(cnt);
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