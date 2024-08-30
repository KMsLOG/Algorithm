import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Light implements Comparable<Light>{
	int node1;
	int node2;
	int cost;
	
	public Light(int node1, int node2, int cost) {
		this.node1 = node1;
		this.node2 = node2;
		this.cost = cost;
	}

	@Override
	public int compareTo(Light o) {
		return this.cost - o.cost;
	}
}
public class Main {
	static int V,E;
	static PriorityQueue<Light> pq = new PriorityQueue<>();
	static int[] rank;
	static int[] parent;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			if (V == 0 && E == 0) {
				break;
			}
			
			rank = new int[V];
			parent = new int[V];
			for(int i = 0 ; i<V;i++) {
				parent[i] = i;
			}
			int totalcost = 0;
			for(int i = 0 ; i<E;i++) {
				st= new StringTokenizer(br.readLine());
				int node1 = Integer.parseInt(st.nextToken());
				int node2 = Integer.parseInt(st.nextToken());
				int cost = Integer.parseInt(st.nextToken());
				pq.add(new Light(node1,node2,cost));
				totalcost+=cost;
			}
			int min = kruskal();
			System.out.println(totalcost-min);
			
		}
		
		
		
	} // end of main
	
	
	static int kruskal() {
		int cost = 0;
		while(!pq.isEmpty()) {
			Light cur = pq.poll();
			
			if(find(cur.node1)!=find(cur.node2)) {
				union(cur.node1,cur.node2);
				cost+=cur.cost;
			}
		}
		return cost;
	} // end of kruskal
	
	static void union(int x, int y) {
		int rootX = find(x);
		int rootY = find(y);
		
		if(rootX != rootY) {
			if(rank[rootX]>rank[rootY]) {
				parent[rootY] = rootX;
			} else if(rank[rootX]<rank[rootY]) {
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
