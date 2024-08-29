import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


class Network implements Comparable<Network>{
	int node1;
	int node2;
	int cost;
	public Network(int node1, int node2, int cost) {
		this.node1 = node1;
		this.node2 = node2;
		this.cost = cost;
	}
	@Override
	public int compareTo(Network o) {
		return this.cost -o.cost;
	}	
}

public class Main {
	
	static int V,E;
	static PriorityQueue<Network> pq;
	static int[] parent;
	static int[] rank;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		V = Integer.parseInt(br.readLine());
		E = Integer.parseInt(br.readLine());
		parent = new int[V+1];
		for(int i = 0 ; i<V+1;i++) {
			parent[i] = i;
		}
		rank = new int[V+1];
		
		pq = new PriorityQueue<>();
		
		for(int i = 0 ; i<E;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int node1 = Integer.parseInt(st.nextToken());
			int node2 = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			pq.add(new Network(node1, node2, cost));
		}
		
		kruskal();
		
	} // end of main
	
	static void kruskal() {
		int cost = 0;
		int size = pq.size();
		for(int i = 0 ; i<size;i++) {
			Network cur = pq.poll();
			
			if(find(cur.node1)!=find(cur.node2)) {
				union(cur.node1,cur.node2);
				cost+=cur.cost;
			}
		}
		System.out.println(cost);
	}
	
	static void union(int x, int y) {
		int rootX = find(x);
		int rootY = find(y);
		
		if(rootX != rootY) {
			if(rank[rootX]>rank[rootY]) {
				parent[rootY] = rootX;
			} else if(rank[rootX] < rank[rootY]) {
				parent[rootX] = rootY;
			} else {
				parent[rootY] = rootX;
				rank[rootX]++;
			}
		}
		
	} // end of union
	
	static int find(int x) {
		if(parent[x] == x) {
			return x;
		} else {
			return find(parent[x]);
		}
	} // end of find
} // end of class
