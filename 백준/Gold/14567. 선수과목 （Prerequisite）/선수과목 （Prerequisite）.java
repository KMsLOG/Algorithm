import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] semester = new int[N+1];
		Arrays.fill(semester, 1);
		List<Integer>[] graph = new ArrayList[N+1];
		Queue<Integer> q = new ArrayDeque<>();
		
		for(int i = 0 ; i<=N ;i++) {
			graph[i] = new ArrayList<>();
		}
		int[] degree = new int[N+1];
		
		for(int i = 0 ;i<M ;i++) {
			st = new StringTokenizer(br.readLine());
			int pre = Integer.parseInt(st.nextToken());
			int post = Integer.parseInt(st.nextToken());
			graph[pre].add(post);
			degree[post]++;
		}
		for(int i =1 ; i<=N ;i++) {
			if(degree[i]==0) {
				q.add(i);
			}
		}
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			for(int post : graph[cur]) {
				degree[post]--;
				semester[post]= Math.max(semester[post], 1+semester[cur]);
				if(degree[post]==0) {
					q.add(post);
				}
			}
		}
		
		for(int i =1 ;i<=N ; i++) {
			System.out.print(semester[i]+" ");
		}
	} // end of main
} // end of class
