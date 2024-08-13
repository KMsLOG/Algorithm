import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_SWEA_1225_암호생성기_D3_조강민_137ms {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (int T = 1; T <= 10; T++) {
			int tc = Integer.parseInt(br.readLine()); 
			Queue<Integer> queue = new LinkedList<>(); 
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < 8; i++) {
				queue.offer(Integer.parseInt(st.nextToken())); 
			}
			
			int count = 1; 
			
			while (true) {
				int first = queue.poll() - count++;
				
				if (first <= 0) { 
					queue.offer(0); 
					break; 
				}
				
				if (count == 6) {
					count = 1;
				}
				
				queue.offer(first);
			}
			
			sb.append("#"+tc+" ");
			
			for (int i = 0; i < 8; i++) {
				sb.append(queue.poll()).append(" ");
			}
			sb.append("\n");
		} // end of tc
		System.out.print(sb);
	} // end of main
} // end of class
