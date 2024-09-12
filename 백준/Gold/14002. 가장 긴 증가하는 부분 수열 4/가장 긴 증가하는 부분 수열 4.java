import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for(int i = 0 ;i<N ;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		int dp[] = new int[N];
		Arrays.fill(dp, 1);
		int max = 0;
		for(int i = 0 ;i<N;i++) {
			for(int j = 0 ; j<i;j++) {
				if(arr[i]>arr[j] && i>=1) {
					dp[i] = Math.max(dp[i], dp[j]+1);
				}
			}
			max = Math.max(max, dp[i]);
		}
		
		
		sb.append(max+"\n");
		
		for(int i = N-1;i>=0;i--) {
			if(max ==0) {
				break;
			}
			if(dp[i]==max) {
				pq.add(arr[i]);
				max--;
			}
		}
		
		
		
		while(!pq.isEmpty()) {
			sb.append(pq.poll()+" ");
		}
		System.out.print(sb);
	} // end of main
} // end of class
