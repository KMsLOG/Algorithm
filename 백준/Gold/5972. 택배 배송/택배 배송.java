import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Edge {
	int end;
	int dis;
	public Edge(int end, int dis) {
		this.end = end;
		this.dis = dis;
	}
} // end of Edge

public class Main {
	static int V, M;
    static ArrayList<Edge>[] list;
    static int[] cost;
    static final int INF = Integer.MAX_VALUE;
    
    static void dijstra(int start) {
    	Queue<Edge> q = new LinkedList<>();
    	q.add(new Edge(start,0));
    	cost[start] = 0;
    	while(!q.isEmpty()) {
    		Edge cur = q.poll();
    		for(Edge next : list[cur.end]) {
    			if(cost[next.end] > cost[cur.end]+next.dis ) {
    				cost[next.end] = cost[cur.end]+next.dis;
    				q.add(new Edge(next.end,cost[next.end]));
    			}
    		}
    	}
    } // end of dijstra
    
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		cost = new int[V+1];
        Arrays.fill(cost, INF);
        list = new ArrayList[V+1];
        for(int i=0; i<=V; i++) {
        	list[i] = new ArrayList<>();
        }
        
        for(int i=0;i<M;i++) {
        	st = new StringTokenizer(br.readLine());
        	int v = Integer.parseInt(st.nextToken());
        	int end = Integer.parseInt(st.nextToken());
        	int dis = Integer.parseInt(st.nextToken());
        	
        	list[v].add(new Edge(end,dis));
        	list[end].add(new Edge(v,dis));
        }
        dijstra(1);
        System.out.println(cost[V]);
        
        
        
	} // end of main
} // end of class
