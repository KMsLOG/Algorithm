import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Planet implements Comparable<Planet>{
	int node1;
	int node2;
	int cost;
	
	public Planet(int node1, int node2, int cost) {
		super();
		this.node1 = node1;
		this.node2 = node2;
		this.cost = cost;
	}

	@Override
	public int compareTo(Planet o) {
		return this.cost - o.cost ;
	}

}

public class Main {
	static int N;
	static PriorityQueue<Planet> pq;
	static int[] rank;
	static int[] parent;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		rank = new int[N];
		parent = new int[N];
		pq = new PriorityQueue<>();
		for(int i = 0 ; i<N;i++) {
			parent[i] = i;
			rank[i] = 0;
		}
		for(int i = 0 ; i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j<N;j++) {
				int num = Integer.parseInt(st.nextToken());
				if(j>i) {
					pq.add(new Planet(i,j,num));
				}
				
			}
		}
		
		kruskal();
	} // end of main
	
	static void kruskal() {
		long totalCost = 0;
        
        while(!pq.isEmpty()) {
            Planet cur = pq.poll();
            if (find(cur.node1) != find(cur.node2)) {
                union(cur.node1, cur.node2);
                totalCost += cur.cost;
            }
        }
        System.out.println(totalCost);

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
	} // end of static
	
} // end of class
