import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static int N, start;
	static HashSet<Integer>[] arr;
	static boolean[] visited;
	static List<Integer> list;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for(int tc =1 ; tc<=10;tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			start = Integer.parseInt(st.nextToken());
			arr = new HashSet[101];
			
			for(int i= 0 ;i<=100;i++) {
				arr[i] = new HashSet<>();
			}
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i<N/2;i++) {
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				arr[start].add(end);
			}
			
			visited = new boolean[101];
			list = new ArrayList<>();
			bfs(start);
			
			
			sb.append("#"+tc+" "+list.get(list.size()-2)+"\n");
		} // end of tc
		System.out.print(sb);
	} // end of main
	
	static void bfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		visited[start] = true;
		
		while(!q.isEmpty()) {
			int qSize = q.size();
			int max = 0;
			for(int i = 0 ; i<qSize;i++) {
				int cur = q.poll();
				for(int next : arr[cur]) {
					if(!visited[next]) {
						visited[next]= true;
						q.add(next);
						max = Math.max(max, next);
					}
				}
			}
			list.add(max);
		}
	} // end of bfs
} // end of class
