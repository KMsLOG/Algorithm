import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		
		for(int i = N-1 ;i>=0 ;i--) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		int cnt = 0;
		int idx = 0;
		while(K!=0) {
			cnt += K/arr[idx];
			K = K%arr[idx];
			idx++;
		}
		System.out.println(cnt);
	} // end of main
} // end of class
