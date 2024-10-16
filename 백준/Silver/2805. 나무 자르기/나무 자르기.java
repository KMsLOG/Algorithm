import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] trees = new int[N];
		int max = 0;
		int min = 0; 
		int mid = 0;
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i<N ; i++) {
			trees[i] = Integer.parseInt(st.nextToken());
			if(max<trees[i]) {
				max = trees[i];
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
			
			for(int i= 0 ; i<N ;i++) {
				m+=((trees[i]-mid)>=0 ? (trees[i]-mid):0);
			}
			
			if(m<M) {
				max = mid;
			} else {
				min = mid+1;
			}
		}
		System.out.println(min-1);
	} // end of main
} // end of class
