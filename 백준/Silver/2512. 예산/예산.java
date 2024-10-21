import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int min = 0;
		int max = 0;
		int mid = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0 ; i<N ;i++) {
			int num = Integer.parseInt(st.nextToken());
			if(num>max) {
				max = num;
			}
			arr[i] = num;
		}
		
		int M = Integer.parseInt(br.readLine());
		
		max++;
		
		while(min<max) {
			mid = (min+max)/2;
			long m = 0;
			
			for(int i = 0 ;i<N ;i++) {
				m+=Math.min(arr[i], mid);
			}
			
			if(m<=M) {
				min = mid+1;
			} else {
				max = mid;
			}
			
			
		}
		System.out.println(min-1);
	} // end of main
} // end of class
