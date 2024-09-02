import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Road implements Comparable<Road>{
	int node1;
	int node2;
	int cost;
	public Road(int node1, int node2, int cost) {
		this.node1 = node1;
		this.node2 = node2;
		this.cost = cost;
	}
	@Override
	public int compareTo(Road o) {
		return this.cost - o.cost;
	}
}


public class Main {
	static int V,E;
	static int[] parent;
	static int[] rank;
	static PriorityQueue<Road> pq = new PriorityQueue<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		parent = new int[V+1];
		for(int i = 0 ; i<V+1;i++) {
			parent[i] = i;
		}
		rank = new int[V+1];
		long total_cost = 0;
		for(int i = 0 ; i<E ;i++) {
			st = new StringTokenizer(br.readLine());
			int node1 = Integer.parseInt(st.nextToken());
			int node2 = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			pq.add(new Road(node1,node2,cost));
			total_cost+=cost;
		}
		long cost = kruskal();
		boolean flag = true;
		for(int i = 2 ; i<V+1;i++) {
			if(find(1)!=find(i)) {
				System.out.println(-1);
				flag =false;
				break;
			}
		}
		if(flag) {
			System.out.println(total_cost - cost);
		}
	} // end of main
	
	static long kruskal() {
		long cost = 0;
		while(!pq.isEmpty()) {
			Road cur = pq.poll();
			
			if(find(cur.node1)!=find(cur.node2)) {
				cost+=cur.cost;
				union(cur.node1,cur.node2);
			}
		}
		return cost;
	}
	
	
	static void union(int x, int y) {
		int rootX = find(x);
		int rootY = find(y);
		
		if(rootX != rootY) {
			if(rank[rootX]>rank[rootY]) {
				parent[rootY] = rootX;
			} else if (rank[rootX]<rank[rootY]) {
				parent[rootX] = rootY;
			} else {
				parent[rootY] = rootX;
				rank[rootX]++;
			}
		}
		
	} // end of union
	
	
	static int find(int x) {
		if(parent[x]==x) {
			return x;
		} else {
			return find(parent[x]);
		}
	} // end of find
} // end of class
