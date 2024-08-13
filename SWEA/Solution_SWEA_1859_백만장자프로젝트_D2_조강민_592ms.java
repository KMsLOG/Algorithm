import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_SWEA_1859_백만장자프로젝트_D2_조강민_592ms {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int tc =1 ; tc<=T ; tc++) {
			int N = Integer.parseInt(br.readLine());
			String s = br.readLine();
			StringTokenizer st = new StringTokenizer(s);
			int[] arr = new int[N];
			for(int i = 0 ; i <N;i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			long sum = 0;
			
			int post = arr[arr.length-1];
			for(int i = arr.length-2;i>=0;i--) {
				if(post>=arr[i]) {
					sum += post-arr[i];
				} else {
					post = arr[i];
				}
			}
			sb.append("#"+tc+" "+sum+"\n");
			
		} // end of tc
		System.out.print(sb);
	} // end of main
} // end of class