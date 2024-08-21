import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


class Node implements Comparable<Node> {
	int end;
	int cost;
	public Node(int end, int cost) {
		super();
		this.end = end;
		this.cost = cost;
	}
	@Override
	public int compareTo(Node o) {
		return this.cost - o.cost;
	}
	
	
}


public class Main {
	
	static int V,E;
	static ArrayList<Node>[] arr;
	static int[] COST;
	static final int INF = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		arr= new ArrayList[V+1];
		for(int i = 0 ; i<V+1;i++) {
			arr[i] = new ArrayList<>();
		}
		int start = Integer.parseInt(br.readLine());
		for(int i = 0 ; i<E ;i++) {
			st = new StringTokenizer(br.readLine());
			int parent = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			arr[parent].add(new Node(end,cost));
		}
		COST = new int[V+1];
		Arrays.fill(COST, INF);
		dijkstra(start);
		
		for(int i = 1 ; i<V+1;i++) {
			if(COST[i] == INF) {
				System.out.println("INF");
			} else {
				System.out.println(COST[i]);
			}
		}
		
		
		
	} // end of main
	
	static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		COST[start] = 0;
		pq.add(new Node(start,0));
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			if(COST[cur.end]<cur.cost) {
				continue;
			}
			for(Node next : arr[cur.end]) {
				if(COST[next.end]>COST[cur.end]+next.cost) {
					COST[next.end]=COST[cur.end]+next.cost;
					pq.add(new Node(next.end,COST[next.end]));
				}
			}
		}
		
	} // end of dijkstra 
} // end of class
