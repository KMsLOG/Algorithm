import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	
	static List<Integer>[] arr;
	static int num;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1 ; tc<=T ;tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			arr = new ArrayList[N+1];
			for(int i = 0 ; i<=N;i++) {
				arr[i] = new ArrayList<>();
			}
			
			visited = new boolean[N+1];
			
			num = 0;
			
			for(int i = 0;i<M;i++) {
				st = new StringTokenizer(br.readLine());
				int node1 = Integer.parseInt(st.nextToken());
				int node2 = Integer.parseInt(st.nextToken());
				
				arr[node1].add(node2);
				arr[node2].add(node1);
			}
			
			for(int i = 1 ;i<=N;i++) {
				if(!visited[i]) {
					bfs(i);
					num++;
				}
			}
			
			
			sb.append("#"+tc+" "+num+"\n");
		} // end of tc
		System.out.print(sb);
	} // end of main
	
	static void bfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		visited[start] = true;
		q.add(start);
		while(!q.isEmpty()) {
			int cur = q.poll();
			for(int next : arr[cur]) {
				if(!visited[next]) {
					visited[next] = true;
					q.add(next);
				}
			}
		}
	} // end of bfs
} // end of class
