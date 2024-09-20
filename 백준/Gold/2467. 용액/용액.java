import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i<N ;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int left = 0;
        int right = N - 1;
        int minSum = Integer.MAX_VALUE;
        int[] minNums = new int[2];

        // 두 포인터를 이용한 탐색
        while (left < right) {
            int sum = arr[left] + arr[right];

            // 현재 합의 절댓값과 최소값 비교
            if (Math.abs(sum) < minSum) {
                minSum = Math.abs(sum);
                minNums[0] = arr[left];
                minNums[1] = arr[right];
            }

            // 합이 0보다 크면 오른쪽 포인터를 줄이고, 작으면 왼쪽 포인터를 증가
            if (sum > 0) {
                right--;
            } else {
                left++;
            }
        }
		
		System.out.println(minNums[0]+" "+minNums[1]);
	}
}
