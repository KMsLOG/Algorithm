import java.io.*;
import java.util.*;

public class Main {
    static int N,cnt;
    static ArrayList<Integer>[] tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        cnt=0;
        StringTokenizer st = new StringTokenizer(br.readLine());

        tree = new ArrayList[N];
        for(int i=0;i<N;i++){
            tree[i] = new ArrayList<>();
        }

        int start = -1;
        for(int i = 0 ;i<N ;i++){
            int parent = Integer.parseInt(st.nextToken());
            if(parent==-1){
                start = i;
                continue;
            };
            tree[parent].add(i);
        }
        int remove = Integer.parseInt(br.readLine());
        dfs(start,remove);
        System.out.println(cnt);
    } // end of main
    static void dfs(int start, int remove){
        if(start == remove) return;

        boolean hasChild = false;
        for(int child : tree[start]){
            if(child != remove){
                hasChild = true;
                dfs(child, remove);
            }
        }

        if(!hasChild){
            cnt++;
        }
    } // end of dfs
}
