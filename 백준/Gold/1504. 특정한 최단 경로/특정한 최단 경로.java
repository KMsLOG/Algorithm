import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node2 implements Comparable<Node2> {
	int end;
	int cost;
	public Node2(int end, int cost) {
		super();
		this.end = end;
		this.cost = cost;
	}
	@Override
	public int compareTo(Node2 o) {
		return this.cost - o.cost;
	}
}

public class Main{
	static int V,E;
	static ArrayList<Node2>[] arr;
	static int[] COST;
	static final int INF = 200000000;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		arr= new ArrayList[V+1];
		for(int i = 0 ; i<V+1;i++) {
			arr[i] = new ArrayList<>();
		}
		for(int i = 0 ; i<E ;i++) {
			st = new StringTokenizer(br.readLine());
			int parent = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			arr[parent].add(new Node2(end,cost));
			arr[end].add(new Node2(parent,cost));
		}
		COST = new int[V+1];
		Arrays.fill(COST, INF);
		st = new StringTokenizer(br.readLine());
		int v1 = Integer.parseInt(st.nextToken());
		int v2 = Integer.parseInt(st.nextToken());
		// 첫번째 경우
		long sum1 = 0;
	;
		sum1+= dijkstra(1, v1);
		sum1+= dijkstra(v1, v2);
		sum1+= dijkstra(v2, V);
		// 두번째 경우
		long sum2 = 0;
		
		sum2+= dijkstra(1, v2);
		sum2+= dijkstra(v2, v1);
		sum2+= dijkstra(v1, V);
		
		long ans = (sum1 >= INF && sum2 >= INF) ? -1 : Math.min(sum1, sum2);
		System.out.println(ans);
	} // end of main
	
	
	static int dijkstra(int start, int end) {
		Arrays.fill(COST, INF);
		PriorityQueue<Node2> pq = new PriorityQueue<>();
		COST[start] = 0;
		pq.add(new Node2(start,0));
		while(!pq.isEmpty()) {
			Node2 cur = pq.poll();
			if(COST[cur.end]<cur.cost) {
				continue;
			}
			for(Node2 next : arr[cur.end]) {
				if(COST[next.end]>COST[cur.end]+next.cost) {
					COST[next.end]=COST[cur.end]+next.cost;
					pq.add(new Node2(next.end,COST[next.end]));
				}
			}
		}
		return COST[end];
	} // end of dijkstra
} // end of class
