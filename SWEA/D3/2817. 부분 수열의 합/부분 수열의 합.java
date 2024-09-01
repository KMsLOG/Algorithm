import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int N,K;
	static int[] arr;
	static int sum;
	static int cnt;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb= new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1 ; tc<=T ; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			arr = new int[N];
			st = new StringTokenizer(br.readLine());
			for(int i = 0 ;i<N;i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			sum = 0;
			cnt = 0;
			
			for(int r = 0 ;r<=N;r++) {
				comb(0,r);
			}
			
			sb.append("#"+tc+" "+cnt +"\n");
		}
		System.out.print(sb);
	} // end of main
	static void comb(int start, int r) {
		if(sum>K) {
			return;
		}
		
		if(r==0) {
			if(sum==K) {
				cnt++;
			}
			return;
		}
		for(int i = start; i<N;i++) {
			sum+=arr[i];
			comb(i+1,r-1);
			sum-=arr[i];
		}
	} // end of comb
} // end of class
