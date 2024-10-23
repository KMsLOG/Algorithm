import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long[] arr = new long[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i<N ;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		
		long minSum = Long.MAX_VALUE;
		
		long leftNum = 0;
		long midNum = 0;
		long rightNum = 0;
		
        loop : for (int left = 0; left < N - 2; left++) {
            int mid = left + 1;
            int right = N - 1;
            
            while (mid < right) {
                long sum = arr[left] + arr[mid] + arr[right];
                
                if (Math.abs(sum) < Math.abs(minSum)) {
                    minSum = sum;
                    leftNum = arr[left];
                    midNum = arr[mid];
                    rightNum = arr[right];
                }
                
                if (sum == 0) {
                    break loop;
                }
                
                if (sum > 0) {
                    right--;
                } else {
                    mid++;
                }
            }
        }
        System.out.println(leftNum + " " + midNum + " " + rightNum);
	} // end of main
} // end of class
