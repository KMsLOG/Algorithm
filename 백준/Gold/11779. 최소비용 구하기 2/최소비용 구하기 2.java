import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Bus2 implements Comparable<Bus2>{
	int end;
	int cost;
	public Bus2(int end, int cost) {
		super();
		this.end = end;
		this.cost = cost;
	}
	@Override
	public int compareTo(Bus2 o) {
		return Integer.compare(this.cost, o.cost);
	}
	
	
}



public class Main {
	static int V,E;
	static ArrayList<Bus2>[] arr;
	static final int INF = Integer.MAX_VALUE;
	static int[] dist;
	static ArrayList<Integer>[] busstop;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		V = Integer.parseInt(br.readLine());
		E = Integer.parseInt(br.readLine());
		
		arr = new ArrayList[V+1];
		dist = new int[V+1];
		busstop = new ArrayList[V+1];
		Arrays.fill(dist, INF);
		
		for(int i =1 ;i<V+1;i++) {
			arr[i] = new ArrayList<>();
			busstop[i] = new ArrayList<>();
		}
		
		
		for(int i = 0 ; i<E;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int parent = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			arr[parent].add(new Bus2(end,cost));
		}
		StringTokenizer st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		dijkstra(start);
		
		System.out.println(dist[end]);
		System.out.println(busstop[end].size());
		for(int i : busstop[end]) {
			System.out.print(i + " ");
		}
	} // end of main
	
	
	static void dijkstra(int start) {
		PriorityQueue<Bus2> pq = new PriorityQueue<>();
		pq.add(new Bus2(start,0));
		dist[start] = 0;
		busstop[start].add(start);
		
		while(!pq.isEmpty()) {
			Bus2 cur = pq.poll();
			if(dist[cur.end]<cur.cost) {
				continue;
			}
			for(Bus2 next : arr[cur.end]) {
				if(dist[next.end] > dist[cur.end] + next.cost) {
					dist[next.end] = dist[cur.end] + next.cost;
					pq.add(new Bus2(next.end,dist[next.end]));
					busstop[next.end] = new ArrayList<>();
					for(int i : busstop[cur.end]) {
						busstop[next.end].add(i);
					}
					busstop[next.end].add(next.end);
				}
			}
			
		}
	} // end of dijkstra
	
} // end of class