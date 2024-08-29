import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Town implements Comparable<Town>{
	int node1;
	int node2;
	int cost;
	public Town(int node1, int node2, int cost) {
		this.node1 = node1;
		this.node2 = node2;
		this.cost = cost;
	}
	@Override
	public int compareTo(Town o) {
		return this.cost - o.cost;
	}
}

public class Main {
	static int V,E;
	static int[] parent;
	static int[] rank;
	static PriorityQueue<Town> pq;
	static int max = 0;
	
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
		
		pq = new PriorityQueue<>();
		
		for(int i = 0 ; i<E ;i++) {
			st = new StringTokenizer(br.readLine());
			int node1 = Integer.parseInt(st.nextToken());
			int node2 = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			pq.add(new Town(node1, node2, cost));
		}
		
		kruskal();
	} // end of main
	
	static void kruskal() {
		int cost = 0;
		int size = pq.size();
		
		for(int i = 0 ;i<size;i++) {
			Town cur = pq.poll();
			if(find(cur.node1)!=find(cur.node2)) {
				union(cur.node1,cur.node2);
				cost+=cur.cost;
				max = Math.max(max, cur.cost);
			}
		}
		System.out.println(cost-max);
	} // end of kruskal
	
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
