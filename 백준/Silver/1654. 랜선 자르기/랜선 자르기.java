import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int[] arr = new int[K];
		long max = 0;
		long mid = 0;
		long min = 0;
		
		for(int i = 0 ; i<K ;i++) {
			arr[i] = Integer.parseInt(br.readLine());
			if(max<arr[i]) {
				max = arr[i];
			}
		}
		max++;
		long n;
		while(min<max) {
			n=0;
			mid = (min+max)/2;
			if(mid==0) {
				min = 1;
				break;
			}
			for(int i = 0 ; i<K ;i++) {
				n+=(arr[i]/mid);
			}
			
			if(n<N) {
				max = mid;
			} else {
				min =mid+1;
			}
		}
		System.out.println(min-1);
	} // end of main
} // end of class
