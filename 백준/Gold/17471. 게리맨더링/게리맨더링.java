import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static ArrayList<Integer>[] arr;
    static int min = Integer.MAX_VALUE;
    static int[] people;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        people = new int[N+1];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            people[i] = Integer.parseInt(st.nextToken());
        }
        
        arr = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            arr[i] = new ArrayList<>();
        }
        
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            for (int j = 0; j < n; j++) {
                arr[i].add(Integer.parseInt(st.nextToken()));
            }
        }
        
        ArrayList<Integer> area1 = new ArrayList<>();
        for (int i = 1; i <= N / 2; i++) {
            comb(1, N, i, area1);
        }
        if (min == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(min);
        }
    } // end of main
    
    static void comb(int start, int N, int r, ArrayList<Integer> area) {
        if (r == 0) {
            diff(area);
            return;
        }
        
        for (int i = start; i <= N; i++) {
            area.add(i);
            comb(i + 1, N, r - 1, area);
            area.remove(area.size() - 1);
        }
    } // end of comb
    
    static void diff(ArrayList<Integer> area) {
        if (!bfs(area.get(0), area)) {
            return;
        }
        
        ArrayList<Integer> area2 = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            if (!area.contains(i)) {
                area2.add(i);
            }
        }
        
        if (!bfs(area2.get(0), area2)) {
            return;
        }
        
        int sum1 = 0;
        for (int i : area) {
            sum1 += people[i];
        }
        
        int sum2 = 0;
        for (int i : area2) {
            sum2 += people[i];
        }
        
        int totalsum = Math.abs(sum1 - sum2);
        min = Math.min(totalsum, min);
    } // end of diff
    
    static boolean bfs(int start, ArrayList<Integer> area) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[N + 1];
        visited[start] = true;
        q.add(start);
        int cnt = 1;
        
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int next : arr[cur]) {
                if (!visited[next] && area.contains(next)) {
                    visited[next] = true;
                    cnt++;
                    q.add(next);
                }
            }
        }
        
        return cnt == area.size();
    } // end of bfs
} // end of class
