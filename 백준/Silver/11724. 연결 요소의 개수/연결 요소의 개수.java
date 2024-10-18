import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static List<Integer>[] arr;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new ArrayList[N+1];
		visited = new boolean[N+1];
		
		for(int i = 0 ; i<=N ;i++) {
			arr[i] = new ArrayList<>();
		}
		
		for(int i = 0 ; i<M ;i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			arr[u].add(v);
			arr[v].add(u);
		}
		int cnt = 0;
		for(int i = 1 ; i<=N ;i++) {
			if(!visited[i]) {
				bfs(i);
				cnt++;
			}
		}
		System.out.println(cnt);
	} // end of main
	
	static void bfs(int start) {
		Queue<Integer>q = new ArrayDeque<>();
		q.add(start);
		visited[start] = true;
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			for(int next : arr[cur]) {
				if(!visited[next]) {
					q.add(next);
					visited[next] = true;
				}
			}
		}
	}
} // end of class
