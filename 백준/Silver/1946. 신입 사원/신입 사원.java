import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc= 0 ; tc<T;tc++) {
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N+1];
			
			for(int i = 0 ;i<N;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int paper = Integer.parseInt(st.nextToken());
				int interview = Integer.parseInt(st.nextToken());
				
				arr[paper] = interview;
			}
			
			int cnt = 1;
			int rank = arr[1];
			for(int i = 2 ;i<=N;i++) {
				if(arr[i]<rank) {
					rank = arr[i];
					cnt++;
				}
			}
			sb.append(cnt+"\n");
		} // end of tc
		System.out.print(sb);
	} // end of main
} // end of class
