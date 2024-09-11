import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int V,E;
	static List<Integer>[] graph;
	static int[] colors;
	static boolean check;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 0 ; tc<T ; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			
			graph = new List[V+1];
			
			for(int i = 0 ; i<=V ; i++) {
				graph[i] = new ArrayList<>();
			}
			
			colors = new int[V+1];
			check = true;
			
			for(int i = 0 ; i <E ; i++) {
				st = new StringTokenizer(br.readLine());
				int node1 = Integer.parseInt(st.nextToken());
				int node2 = Integer.parseInt(st.nextToken());
				graph[node1].add(node2);
				graph[node2].add(node1);
			}
			
			for(int i =1 ;i<=V ;i++) {
				if(colors[i]==0) {
					bfs(i,1);
				}
			}
			if(check) {
				sb.append("YES \n");
			} else {
				sb.append("NO \n");
			}
		} // end of tc
		System.out.print(sb);
	} // end of main
	
	static void bfs(int start, int color) {
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		colors[start] = color;
		while(!q.isEmpty()) {
			int cur = q.poll();
			for(int next : graph[cur]) {
				if(colors[next] == 0) {
					q.add(next);
					colors[next] = colors[cur]*(-1);
				}
				if(colors[next] + colors[cur] !=0) {
					check = false;
					return;
				}
				
			}
		}
	} // end of bfs
	
} // end of class
