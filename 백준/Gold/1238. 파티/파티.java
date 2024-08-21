import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


class Party implements Comparable<Party>{
	int end;
	int cost;
	public Party(int end, int cost) {
		this.end = end;
		this.cost = cost;
	}
	@Override
	public int compareTo(Party o) {
		return this.cost - o.cost;
	}
	
	
}

public class Main {
	static int V,E,X;
	static ArrayList<Party>[] arr;
	static int[] COST;
	static final int INF = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		arr = new ArrayList[V+1];
		
		for(int i = 0 ; i<V+1;i++) {
			arr[i] = new ArrayList<>(); 
		}
		
		COST = new int[V+1];
		
		for(int i = 0 ; i<E ;i++) {
			st = new StringTokenizer(br.readLine());
			int parent = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			arr[parent].add(new Party(end,cost));
		}
		int max = Integer.MIN_VALUE;
		for(int i = 1 ; i<V+1; i++) {
			int sum = dijkstra(i, X)+dijkstra(X, i);
			
			max = Math.max(max, sum);
		}
		
		System.out.println(max);
		
		
	} // end of main
	
	static int dijkstra(int start, int end) {
		Arrays.fill(COST, INF);
		PriorityQueue<Party> pq = new PriorityQueue<>();
		COST[start] = 0;
		pq.add(new Party(start,0));
		while(!pq.isEmpty()) {
			Party cur = pq.poll();
			if(COST[cur.end]<cur.cost) {
				continue;
			}
			for(Party next : arr[cur.end]) {
				if(COST[next.end] > COST[cur.end]+next.cost) {
					COST[next.end] = COST[cur.end]+next.cost;
					pq.add(new Party(next.end,COST[next.end]));
				}
			}
		}
		
		return COST[end];
	}
	
	
	
	
	
} // end of class
