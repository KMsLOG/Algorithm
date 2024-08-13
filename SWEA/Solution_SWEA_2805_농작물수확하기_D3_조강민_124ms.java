import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_SWEA_2805_농작물수확하기_D3_조강민_124ms {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1 ;tc<=T ;tc++) {
			int N = Integer.parseInt(br.readLine());
			int sum = 0;
			for(int i = 0 ; i<N;i++) {
				String s = br.readLine();
				int start = N/2-i;
				int plus = 2*i;
				if( i > N/2) {
					start = (i-N/2)%N;
					plus = 2*(N-i-1);
				}
				
				for(int j = start; j <=start+plus;j++) {
					sum+= s.charAt(j)-'0';
				}
			} // end of for
			sb.append("#"+tc+" "+sum+"\n");
		} // end of tc
		System.out.print(sb);
	} // end of main
} // end of class

