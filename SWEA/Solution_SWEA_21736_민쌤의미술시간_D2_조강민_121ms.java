import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



public class Solution_SWEA_21736_민쌤의미술시간_D2_조강민_121ms {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc<=T;tc++) {
			String[] nmk = br.readLine().split(" ");
			int N = Integer.parseInt(nmk[0]);
			int M = Integer.parseInt(nmk[1]);
			int K = Integer.parseInt(nmk[2]);
 			int[][] rec = new int[N][M];
 			
 			for(int k = 0 ; k<K;k++) {
 				String[] s = br.readLine().split(" ");
 				int left_r = Integer.parseInt(s[0]);
 				int left_c = Integer.parseInt(s[1]);
 				int right_r = Integer.parseInt(s[2]);
 				int right_c = Integer.parseInt(s[3]);
 				int color_n = Integer.parseInt(s[4]);
 				
 				boolean flag = true;
 				for(int i = left_r; i<=right_r;i++) {
 					for(int j = left_c; j <=right_c;j++) {
 						if(rec[i][j] > color_n) {
 							flag = false;
 							break;
 						}
 					}
 				}
 				if(flag) {
 					for(int i = left_r;i<=right_r;i++) {
 						for(int j = left_c ; j<=right_c;j++) {
 							rec[i][j] = color_n;
 						}
 					}
 				}
 				
 				
 				
 			}
 			int[] cntarr = new int[11];
				
			int max = 0;
			for(int i = 0 ; i<N;i++) {
				for(int j = 0 ; j<M;j++) {
					cntarr[rec[i][j]]++;
				}
			}
 			
			for(int i = 0 ; i<cntarr.length;i++) {
				if(max<cntarr[i]) {
					max = cntarr[i];
				}
			}
		
			sb.append("#"+tc+" "+max+"\n");
		} // end of tc
		System.out.print(sb);
	} // end of main
} // end of class
