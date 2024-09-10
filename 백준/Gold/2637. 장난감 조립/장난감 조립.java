import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

class Part{
	int post;
	int cost;
	public Part(int post, int cost) {
		this.post = post;
		this.cost = cost;
	}
}

public class Main {
	static StringBuilder sb;
    static int N, M;
    static List<Part>[] graph;
    static int[] degree;
    static Queue<Integer> q;
    static Map<Integer,Integer>[] map;
    
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        
        // 인접 리스트 초기화
        graph = new ArrayList[N+1];
        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        
        degree = new int[N+1];
        q = new LinkedList<>();
        
        map = new HashMap[N+1];
        for (int i = 0 ; i<=N ; i++) {
        	map[i] = new HashMap<>();
        }
        
        for(int t = 0 ;t <M ;t++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	int post = Integer.parseInt(st.nextToken());
        	int pre = Integer.parseInt(st.nextToken());
        	int cost = Integer.parseInt(st.nextToken());
        	graph[pre].add(new Part(post,cost));
        	degree[post]++;
        }
        
        for(int i =1 ;i<=N;i++) {
        	if(degree[i]==0) {
        		q.add(i);
        		map[i].put(i, 1);
        	}
        }
        
        sort();
        
        List<Integer> keyset =  new ArrayList<>(map[N].keySet());
        Collections.sort(keyset);
        
        for(int key : keyset) {
        	System.out.println(key+" "+map[N].get(key));
        }
	} // end of main
    
    static void sort() {
    	while(!q.isEmpty()) {
    		int size = q.size();
    		for(int t = 0 ; t<size;t++) {
    			int cur = q.poll();
    			for(Part next : graph[cur]) {
    				for(int key : map[cur].keySet()) {
    					if(map[next.post].containsKey(key)) {
    						map[next.post].put(key, map[next.post].get(key) + map[cur].get(key)*next.cost);
    					} else {
    						map[next.post].put(key, map[cur].get(key)*next.cost);
    					}
    				}
    				degree[next.post]--;
    				if(degree[next.post] == 0) {
    					q.add(next.post);
    				}
    			}
    		}
    	}
    } // end of sort
} // end of class
