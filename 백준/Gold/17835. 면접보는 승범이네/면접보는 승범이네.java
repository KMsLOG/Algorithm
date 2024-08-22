import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


class City implements Comparable<City>{
	int end;
	long dis;
	public City(int end, long dis) {
		this.end = end;
		this.dis = dis;
	}
	@Override
	public int compareTo(City o) {
		return Long.compare(this.dis, o.dis);
	}
}


public class Main {
	static int V,E,K;
	static ArrayList<City>[] arr;
	static final long INF = Long.MAX_VALUE;
	static long[] distance;
	static PriorityQueue<City> pq;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new ArrayList[V+1];
		distance = new long[V+1];
		
		for(int i = 0 ; i<V+1;i++) {
			arr[i] = new ArrayList<>();
		}
		Arrays.fill(distance, INF);
		
		for(int i = 0 ;i<E;i++) {
			st = new StringTokenizer(br.readLine());
			int parent = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int dis = Integer.parseInt(st.nextToken());
			arr[end].add(new City(parent,dis));
		}
		st = new StringTokenizer(br.readLine());
		long max = 0;
		int idx = 0;
		pq = new PriorityQueue<>();
		for(int i = 0 ; i<K;i++) {
			int interview = Integer.parseInt(st.nextToken());
			pq.offer(new City(interview,0));
			distance[interview]= 0;
		}
		dijkstra();
		
		for(int i = 1; i<=V ; i++) {
			if(max<distance[i]) {
				max = distance[i];
				idx = i;
			}
		}
		
		System.out.println(idx);
		System.out.println(max);
	} // end of main
	
	static void dijkstra() {
		while(!pq.isEmpty()) {
			City cur = pq.poll();
			if(distance[cur.end] < cur.dis) {
				continue;
			}
			for(City next : arr[cur.end]) {
				if(distance[next.end]> distance[cur.end]+ next.dis) {
					distance[next.end] = distance[cur.end]+ next.dis;
					pq.add(new City(next.end,distance[next.end]));
				}
			}
		}
	} // end of dijkstra
} // end of class
