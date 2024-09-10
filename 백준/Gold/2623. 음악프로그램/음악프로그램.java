import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb;
    static int N, M;
    static List<Integer>[] graph;
    static int[] degree;
    static Queue<Integer> q;
    
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 인접 리스트 초기화
        graph = new ArrayList[N+1];
        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        
        degree = new int[N+1];
        q = new LinkedList<>();
        
        for(int t = 0 ;t<M ;t++) {
        	st = new StringTokenizer(br.readLine());
        	int n = Integer.parseInt(st.nextToken());
        	int pre = 0;
        	for(int i = 0 ;i<n ; i++) {
        		if(i == 0) {
        			pre = Integer.parseInt(st.nextToken());
        			continue;
        		}
        		int post = Integer.parseInt(st.nextToken());
        		graph[pre].add(post);
        		degree[post]++;
        		pre = post;
        	}
        }
        
        for(int i = 1 ;i<=N;i++) {
        	if(degree[i] == 0) {
        		q.add(i);
        	}
        }
        
        sort();
        
        boolean flag = true;
        
        for(int i = 1 ;i<=N ;i++) {
        	if(degree[i]!=0) {
        		flag = false;
        		break;
        	}
        }
        
        if(flag) {
        	System.out.print(sb);
        } else {
        	System.out.println(0);
        }
	} // end of main
    
    static void sort() {
    	while(!q.isEmpty()) {
    		int size = q.size();
    		for(int t = 0 ;t<size;t++) {
    			int cur = q.poll();
    			sb.append(cur+"\n");
    			
    			for(int i : graph[cur]) {
    				degree[i]--;
    				if(degree[i]==0) {
    					q.add(i);
    				}
    			}
    		}
    	}
    } // end of sort
} // end of class
