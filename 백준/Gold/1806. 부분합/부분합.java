import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		
		int left = 0;
		int right = 0;
		int sum = 0;
		int minCnt = Integer.MAX_VALUE;
		
		
		int[] arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ;i<N ;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		
		while(true) {
			if(sum>=S) {
				minCnt = Math.min(right-left, minCnt);
				sum-=arr[left++];
				
			} else if (right == N) {
				break;
			} else {
				sum+=arr[right++];
			}
		}
		
		if(minCnt == Integer.MAX_VALUE) {
			System.out.println(0);
		} else {
			System.out.println(minCnt);
		}
	} // end of main
} // end of class
