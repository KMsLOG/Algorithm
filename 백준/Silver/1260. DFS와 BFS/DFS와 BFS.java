import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static ArrayList<Integer>[] arr;
	
	static StringBuilder bfssb = new StringBuilder();
	static StringBuilder dfssb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		arr = new ArrayList[N+1];
		
		for(int i = 0 ;i<N+1;i++) {
			arr[i] = new ArrayList<>();
		}
		
		for(int i = 0 ;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int parent = Integer.parseInt(st.nextToken());
			int child = Integer.parseInt(st.nextToken());
			
			arr[parent].add(child);
			arr[child].add(parent);
			
		}
		
		for(int i = 0 ; i<N+1 ;i++) {
			Collections.sort(arr[i]);
		}
		
		

		boolean[] dfsvisited = new boolean[N+1];
		boolean[] bfsvisited = new boolean[N+1];
		dfs(dfsvisited,K);
		bfs(bfsvisited,K);
		System.out.println(dfssb);
		System.out.println(bfssb);
	} // end of main
	
	static void dfs(boolean[] visited, int start) {
		visited[start] = true;
		dfssb.append(start +" ");
		
		for(int i = 0 ; i<arr[start].size();i++) {
			if(!visited[arr[start].get(i)]) {
				dfs(visited,arr[start].get(i));
			}
		}
		
	} // end of dfs
	
	static void bfs(boolean[] visited, int start) {
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		visited[start] = true;
		while(!q.isEmpty()) {
			int cur = q.poll();
			bfssb.append(cur+" ");
			for(int i = 0 ; i < arr[cur].size();i++) {
				if(!visited[arr[cur].get(i)]) {
					q.add(arr[cur].get(i));
					visited[arr[cur].get(i)] = true;
				}
			}
		}
	}
	
	
	
} // end of class
