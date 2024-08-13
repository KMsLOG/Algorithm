import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] nk = br.readLine().split(" "); // 첫째 줄 두개의 정수 N, K
		int N = Integer.parseInt(nk[0]);
		int K = Integer.parseInt(nk[1]);
		
		String s = br.readLine();
		int[] arr = new int[N]; // 정수 N개가 있는 배열 arr
		
		StringTokenizer st = new StringTokenizer(s); // 두번째 줄 배열에 숫자 넣기
		for(int i= 0 ; i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		
		int sum = 0;	// 합계 설정
		for(int j = 0; j<K;j++) { // 첫번째 합계 설정
			sum+= arr[j];
		}
		int maxsum =sum;
		int i = 1;
		while(i<N-K+1 && i>0) { // 다음 합계부터는 이전 합계에 첫번쨰 수를 빼고 다음에 들어올 수를 더한다.
			sum = sum - arr[i-1]+arr[i+K-1];
			if(sum>maxsum) {
				maxsum = sum;
			}
			i++;
		}
		
		System.out.println(maxsum);	
	}
}
