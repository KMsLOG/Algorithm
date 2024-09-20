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
		
		int left = 0;
		int right = N-1;
		int minSum = Integer.MAX_VALUE;
		int result = 0;
		
		while(left<right) {
			int sum = arr[left]+arr[right];
			if(minSum>Math.abs(sum)) {
				minSum = Math.abs(sum);
				result = sum;
			}
			
			if(sum>0) {
				right--;
			} else {
				left++;
			}
		}
		System.out.println(result);
	} // end of main
} // end of class
