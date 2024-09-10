import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb;
	static int N,M;
	static List<Integer>[] graph;
	static int[] degree;
	static PriorityQueue<Integer> pq;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList[N+1];
		degree = new int[N+1];
		
		for(int i = 0 ;i<=N;i++) {
			graph[i] = new ArrayList<>();
		}
		
		pq  = new PriorityQueue<>();
		
		for(int t = 0 ;t < M ;t++) {
			st = new StringTokenizer(br.readLine());
			int pre = Integer.parseInt(st.nextToken());
			int post = Integer.parseInt(st.nextToken());
			graph[pre].add(post);
			degree[post]++;
		}
		
		for(int i = 1 ;i<=N;i++) {
			if(degree[i]==0) {
				pq.add(i);
			}
		}
		
		sort();
		
		System.out.print(sb);
	} // end of main
	
	static void sort() {
		while(!pq.isEmpty()) {
			int size = pq.size();
			for(int t = 0 ;t<size;t++) {
				int cur = pq.poll();
				sb.append(cur+" ");
				for(int i : graph[cur]) {
					degree[i]--;
					if(degree[i] == 0) {
						pq.add(i);
					}
				}
			}
		}
	} // end of sort
	
} // end of class
