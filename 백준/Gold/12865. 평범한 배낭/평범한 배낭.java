import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Thing implements Comparable<Thing>{
	int weight;
	int value;
	public Thing(int weight, int value) {
		super();
		this.weight = weight;
		this.value = value;
	}
	@Override
	public int compareTo(Thing o) {
		return this.weight-o.weight;
	}
}

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		PriorityQueue<Thing> pq = new PriorityQueue<>();
		int[][] dp = new int[N+1][K+1];
		
		for(int i = 1 ; i<=N ;i++) {
			st = new StringTokenizer(br.readLine());
			int weight = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			pq.add(new Thing(weight,value));
		}
		
		for(int i = 1 ;i<=N;i++) {
			Thing cur = pq.poll();
			int w = cur.weight;
			int v = cur.value;
			for(int k = 1 ;k<=K;k++) {
				if(k>=w) {
					dp[i][k] = Math.max(dp[i-1][k], dp[i-1][k-w]+v);
				} else {
					dp[i][k] = dp[i-1][k];
				}
			}
		}
		System.out.println(dp[N][K]);
	} // end of main
} // end of class
