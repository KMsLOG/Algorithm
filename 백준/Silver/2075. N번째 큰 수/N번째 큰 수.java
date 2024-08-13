import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		
		// 우선순위 큐
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		// map에 숫자 넣기
		for(int i = 0 ; i<N;i++) {
			String s = br.readLine();
			StringTokenizer st = new StringTokenizer(s);
			for(int j = 0 ; j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 마지막 행 값들 다 넣기
		for(int j = 0 ; j<N;j++) {
			pq.add(map[N-1][j]);
		}
		
		for(int i = N-2 ; i>=0;i--) {
			int cnt = 0;
			for(int j = 0; j<N;j++) {
				if(pq.peek() < map[i][j]) {
					pq.poll();
					pq.add(map[i][j]);
				} else {
					cnt++;
				}
			}
			
			if(cnt == N) {
				break;
			}
		}
		System.out.println(pq.poll());
	} // end of main
} // end of class
