import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		dp = new int[N+1]; // 작업 시간을 저장할 dp
		int time = 0; // 총 작업 시간 초기화
		for(int i = 1 ; i<=N ;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int cost = Integer.parseInt(st.nextToken()); // 걸리는 시간
			int cnt = Integer.parseInt(st.nextToken()); // 선행 작업 개수
			if(cnt == 0) { // 선행 작업이 없으면
				dp[i] = cost; // 자기자신을 작업하는 시간 저장
			}
			for(int j = 0 ;j<cnt;j++) {
				int pre = Integer.parseInt(st.nextToken()); // 선행작업 노드
				dp[i] = Math.max(dp[i], dp[pre]+cost); // 현재 작업 노드는 현재 작업 시간과 선행작업노드에 걸리는 시간 중 max 값으로 갱신
			}
			time = Math.max(time, dp[i]); // 총 작업시간 갱신
			
		}

		System.out.println(time); // 총 작업시간 출력
	} // end of main
} // end of class
