import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		final int[] money = {50000,10000,5000,1000,500,100,50,10};
		for(int tc= 1 ;tc<=T;tc++) {
			int N = Integer.parseInt(br.readLine());
			int[] count = new int[8];
			
			for(int i = 0 ; i<8;i++) {
				if(N/money[i]==0) {
					continue;
				} else {
					int cnt = N/money[i];
					count[i]+=cnt;
					N = N % money[i];
				}
			}
			
			sb.append("#"+tc+"\n");
			
			for(int i : count) {
				sb.append(i+" ");
			}
			sb.append("\n");
		} // end of tc
		System.out.print(sb);
	} // end of main
} // end of class
