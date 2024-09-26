import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		int C = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int[] dp = new int[C]; // cost 저장
		Arrays.fill(dp, Integer.MAX_VALUE);
		int[] cost = new int[N];
		int[] customer = new int[N];
		for(int i = 0 ;i<N ; i++) {
			st = new StringTokenizer(br.readLine());
			int co = Integer.parseInt(st.nextToken());
			int cust = Integer.parseInt(st.nextToken());
			
			cost[i] = co;
			customer[i] = cust;
		}
		
		int minCost = Integer.MAX_VALUE;
		
		Queue<Integer> q = new ArrayDeque<>();
		dp[0] = 0;
		q.add(0);
		
		while(!q.isEmpty()) {
			int curIdx = q.poll();
			for(int i = 0 ; i<N ;i++) {
				if(curIdx+customer[i]<C && dp[curIdx+customer[i]] > dp[curIdx]+cost[i] ) { // 목표 고객수 보다 적으면
					dp[curIdx+customer[i]] =  dp[curIdx]+cost[i];
					q.add(curIdx+customer[i]);
				} else if (curIdx+customer[i]>=C){
					minCost = Math.min(minCost, dp[curIdx]+cost[i]);
				}
			}
		}
		System.out.println(minCost);
	} // end of main
} // end of class
