import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb= new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N+1];
		int[] mistake = new int[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1 ; i<N+1;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if(arr[i-1]>arr[i]) {
				mistake[i-1]++;
			}
			mistake[i] = mistake[i-1];
		}
		
		int Q = Integer.parseInt(br.readLine());
		for(int q = 0 ; q<Q;q++) {
			
			st = new StringTokenizer(br.readLine());
			int startIdx = Integer.parseInt(st.nextToken());
			int endIdx = Integer.parseInt(st.nextToken());
			int cnt = mistake[endIdx-1] - mistake[startIdx-1];
			
			sb.append(cnt+"\n");
		}
		System.out.print(sb);
	} // end of main
} // end of class
