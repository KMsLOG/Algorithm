import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc= 1 ;tc<=T;tc++) {
			int N = Integer.parseInt(br.readLine());
			
			int[] arr = new int[N];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int i = 0 ;i<N;i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			int max = 0;
			long sum = 0;
			
			for(int i = N-1 ;i>=0;i--) {
				if(arr[i]>max) {
					max = arr[i];
				} else {
					sum+=max-arr[i];
				}
			}
			sb.append(sum+"\n");
		}
		System.out.print(sb);
	} // end of main
} // end of class
