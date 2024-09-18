import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main  {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		List<Integer>[] arr = new ArrayList[N];
		List<Integer>[] dp = new ArrayList[N];
		for(int i = 0 ; i<N ;i++) {
			arr[i] = new ArrayList<>();
			dp[i] = new ArrayList<>();
		}
		int cnt = 1;
		for(int i = 0 ; i<N ;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j =0; j<cnt ;j++) {
				int num = Integer.parseInt(st.nextToken());
				arr[i].add(num);
				if(i == N-1) {
					dp[i].add(num);
				}
			}
			cnt++;
		}
		
		
		for(int i = N-2 ; i>=0;i--) {
			for(int j = 0 ; j<=i;j++) {
				dp[i].add(Math.max(arr[i].get(j)+dp[i+1].get(j), arr[i].get(j)+dp[i+1].get(j+1)));
			}
		}
		
		System.out.println(dp[0].get(0));
	} // end of main
} // end of class
