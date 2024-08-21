import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Bus implements Comparable<Bus>{
	int end;
	int cost;
	public Bus(int end, int cost) {
		this.end = end;
		this.cost = cost;
	}
	@Override
	public int compareTo(Bus o) {
		return this.cost - o.cost;
	}
}

public class Main {
	
	static int V,E;
	static int[] COST;
	static ArrayList<Bus>[] city;
	static final int INF = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		V = Integer.parseInt(br.readLine());
		E = Integer.parseInt(br.readLine());
		city = new ArrayList[V+1];
		COST = new int[V+1];
		Arrays.fill(COST, INF);
		for(int i = 0 ; i<V+1;i++) {
			city[i] = new ArrayList<>();
		}
		
		for(int i = 0 ; i<E;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int parent = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			city[parent].add(new Bus(end,cost));
		}
		
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int destination = Integer.parseInt(st.nextToken());
		dijkstra(start);
		System.out.println(COST[destination]);
		
		
	} // end of main
	
	static void dijkstra(int start) {
		PriorityQueue<Bus> pq = new PriorityQueue<>();
		pq.add(new Bus(start,0));
		COST[start] = 0;
		while(!pq.isEmpty()) {
			Bus cur = pq.poll();
			if(cur.cost>COST[cur.end]) {
				continue;
			}
			for(Bus b : city[cur.end]) {
				
				if(COST[b.end] > COST[cur.end]+b.cost) {
					COST[b.end] = COST[cur.end]+b.cost;
					pq.add(new Bus(b.end,COST[b.end]));
				}
			}
		}
	}
	
} // end of class
