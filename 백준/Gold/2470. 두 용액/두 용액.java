import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for(int i = 0 ; i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		int left = 0 ;
		int right = N-1;
		int minSum = Integer.MAX_VALUE;
		
		int minL = 0;
		int minR = 0;
		
		while(left<right) {
			int sum = arr[left]+arr[right];
			
			if(Math.abs(sum)<minSum) {
				minSum = Math.abs(sum);
				minL = arr[left];
				minR = arr[right];
				if(minSum==0) break;
			}
			
			if(sum<0) {
				left++;
			} else if(sum>0) {
				right--;
			}
		}
		System.out.println(minL+" "+minR);
	} // end of main
} // end of class
