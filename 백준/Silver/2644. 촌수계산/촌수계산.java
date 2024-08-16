import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int V,E,Node1,Node2;
	static int res = -1;
	static boolean[] visited;
	static List<Integer>[] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		V = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		Node1 = Integer.parseInt(st.nextToken());
		Node2 = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(br.readLine());
		
		arr = new ArrayList[V+1];
		visited = new boolean[V+1];
		
		for(int i = 0 ;i<arr.length;i++) {
			arr[i] = new ArrayList<>();
		}
		
		for(int i = 0; i<E;i++) {
			st = new StringTokenizer(br.readLine());
			int parent = Integer.parseInt(st.nextToken());
			int child = Integer.parseInt(st.nextToken());
			
			arr[parent].add(child);
			arr[child].add(parent);
		}
		
		dfs(Node1,Node2,0);
		System.out.println(res);
		
	} //  end of main
	
	
	
	static void dfs(int start , int end, int cnt) {
		if(start == end) {
			res = cnt;
			return;
		}
		
		visited[start] = true;
		for(int i = 0 ;i<arr[start].size();i++) {
			int next = arr[start].get(i);
			if(!visited[next]) {
				dfs(next,end,cnt+1);
			}
		}
	}
} // end of class
