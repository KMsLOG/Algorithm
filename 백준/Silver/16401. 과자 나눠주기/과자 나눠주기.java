import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		int[] snacks = new int[N];
		
		st = new StringTokenizer(br.readLine());
		
		int max = 0;
		int min = 0;
		int mid = 0;
		
		for(int i = 0 ; i<N ;i++) {
			snacks[i] = Integer.parseInt(st.nextToken());
			if(max<snacks[i]) {
				max = snacks[i];
			}
		}
		
		max++;
		
		while(min<max) {
			long m = 0;
			
			mid = (min+max)/2;
			
			if(mid==0) {
				min = 1;
				break;
			}
			
			for(int i = 0 ;i<N ; i++) {
				m+=snacks[i]/mid;
			}

			if(m<M) {
				max = mid;
			}else {
				min = mid+1;
			}
			
			
		}
		System.out.println(min-1);
	} // end of main
} // end of class
