import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		PriorityQueue<Long> pq = new PriorityQueue<>();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ;i<N;i++) {
			pq.add(Long.parseLong(st.nextToken()));
		}
		
		int cnt = 0;
		while(cnt<M) {
			long num1 = pq.poll();
			long num2 = pq.poll();
			
			long sum = num1+num2;
			pq.add(sum);
			pq.add(sum);
			cnt++;
		}
		
		long total = 0 ;
		while(!pq.isEmpty()) {
			total+=pq.poll();
		}
		System.out.println(total);
	} // end of main
} // end of class
