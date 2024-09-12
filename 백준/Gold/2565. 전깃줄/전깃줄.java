import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class Node implements Comparable<Node>{
		int start;
		int end;
		public Node(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}
		@Override
		public int compareTo(Main.Node o) {
			return this.start - o.start;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		PriorityQueue<Node> pq = new PriorityQueue<>();
		
		for(int i= 0 ;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			pq.add(new Node(start,end));
		}
		int idx = 0;
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			arr[idx++] = cur.end;
		}
		int max = 0;
		int dp[] = new int[N];
		Arrays.fill(dp, 1);
		
		for(int i = 1 ;i<N;i++) {
			for(int j = 0 ; j<i;j++) {
				if(arr[i]>arr[j]) {
					dp[i] = Math.max(dp[i], dp[j]+1);
				}
			}
			max = Math.max(max, dp[i]);
		}
		
		System.out.println(N-max);
	} // end of main
} // end of class
