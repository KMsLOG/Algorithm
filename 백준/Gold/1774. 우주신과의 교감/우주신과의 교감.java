import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Pnode implements Comparable<Pnode>{
	int r;
	int c;
	double cost;
	public Pnode(int r, int c, double cost) {
		this.r = r;
		this.c = c;
		this.cost = cost;
	}
	@Override
	public int compareTo(Pnode o) {
		return Double.compare(this.cost, o.cost);
	}
	
}



public class Main {
	
	static int V,M;
	static int[] parent;
	static int[] rank;
	static PriorityQueue<Pnode> pq = new PriorityQueue<>();
	static int totalcost = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int[][] god = new int[V+1][2];
		
		for(int i = 1 ; i<=V;i++) {
			st = new StringTokenizer(br.readLine());
			god[i][0] = Integer.parseInt(st.nextToken());
			god[i][1] = Integer.parseInt(st.nextToken());
		}
		parent = new int[V+1];
		for(int i = 0 ; i<V+1;i++) {
			parent[i] = i;
		}
		rank = new int[V+1];
		for(int i = 0 ; i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int node1 = Integer.parseInt(st.nextToken());
			int node2 = Integer.parseInt(st.nextToken());
			union(node1,node2);
		}
		
		for (int i = 1; i < V; i++) {			
            for (int j = i + 1; j < V + 1; j++) {
                int x1 = god[i][0];
                int y1 = god[i][1];
                int x2 = god[j][0];
                int y2 = god[j][1];
				
                double cost = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
				
                pq.add(new Pnode(i, j, cost));
            }
        }
		kruskal();
		
	} // end of main
	
	static void kruskal() {
		double cost = 0;
		while(!pq.isEmpty()) {
			Pnode cur = pq.poll();
			if(find(cur.r)!=find(cur.c)) {
				union(cur.r,cur.c);
				cost+=cur.cost;
			}
		}
		System.out.println(String.format("%.2f", cost));
	}
	
	static void union(int x, int y) {
		
		int rootX = find(x);
		int rootY = find(y);
		
		if(rootX != rootY) {
			if(rank[rootX]>rank[rootY]) {
				parent[rootY] = rootX;
			} else if (rank[rootY]>rank[rootX]) {
				parent[rootX] = rootY;
			} else {
				parent[rootY] = rootX;
				rank[rootX]++;
			}
		}
		
	} // end of union
	
	static int find(int x) {
		if(parent[x]!=x) {
			return find(parent[x]);
		} else {
			return parent[x];
		}
	} // end of find
} // end of class
