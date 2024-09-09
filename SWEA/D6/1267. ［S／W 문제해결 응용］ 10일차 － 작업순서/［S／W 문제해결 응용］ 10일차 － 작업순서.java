import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static int V, E;
	static int[][] graph;
	static int[] degrees;
	static StringBuilder sb;
	static Queue<Integer> q;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		for(int tc = 1 ; tc<=10;tc++) {
			sb.append("#"+tc+" ");
			StringTokenizer st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			
			graph = new int[V+1][V+1];
			degrees = new int[V+1];
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0 ; i<E;i++) {
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				graph[start][end] = 1;
				degrees[end]++;
			}
			q = new LinkedList<>();
			
			for(int i = 1 ;i<=V;i++) {
				if(degrees[i]==0) {
					q.add(i);
				}
			}
			
			sort();
			sb.append("\n");
		} // end of tc
		System.out.print(sb);
	} // end of main
	
	static void sort() {
		while(!q.isEmpty()) {
			int cur = q.poll();
			sb.append(cur+" ");
			for(int i = 1 ; i<=V;i++) {
				if(graph[cur][i]==1) {
					degrees[i]--;
					if(degrees[i]==0) {
						q.add(i);
					}
				}
			}
		}
	} // end of sort
} // end of class
