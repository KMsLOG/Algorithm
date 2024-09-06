import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0 ;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] output = new int[N];
		
		output[arr[0]] = 1;
		
		for(int i = 1 ; i<N;i++) {
			int idx = 0;
			int cnt = -1;
			while(true) {
				if(output[idx]==0) {
					cnt++;
				}
				if(cnt==arr[i]) {
					break;
				}
				idx++;
				
			}
			output[idx] = i+1;
		}
		
		for(int i : output) {
			System.out.print(i+" ");
		}
	} // end of main
} // end of class
