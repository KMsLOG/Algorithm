import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_SWEA_7102_준홍이의카드놀이_D3_조강민_127ms {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1 ; tc<=T;tc++) {
			String[] s = br.readLine().split(" ");
			int N = Integer.parseInt(s[0]);
			int M = Integer.parseInt(s[1]);
			int[] cntarr = new int[N+M+1];
			Queue<Integer> queue = new LinkedList<>();
			for(int i = 1;i<=N;i++) {
				for(int j = 1; j<=M ; j++) {
					cntarr[i+j]++;
				}
			}
			
			queue.offer(0);
			
			for(int i = 1 ; i<cntarr.length;i++) {
				if(cntarr[queue.peek()]<cntarr[i]) {
					queue.clear();
					queue.offer(i);
				} else if (cntarr[queue.peek()]==cntarr[i]) {
					queue.offer(i);
				}
			}
			sb.append("#"+tc+" ");
			for(int n : queue) {
				sb.append(n+" ");
			}
			sb.append("\n");
		} // end of tc
		System.out.println(sb);
	} // end of main
} // end of class
