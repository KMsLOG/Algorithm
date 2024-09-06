import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0 ;i<N;i++){
			pq.add(Integer.parseInt(st.nextToken()));
		}
		
		int cnt = 0;
		
		int prev = pq.poll(); 
		
		while(!pq.isEmpty()) {
			int cur = pq.poll();
			
			if(cur-prev+1>L) {
				cnt++;
				prev= cur;
			}
		}
		
		System.out.println(cnt+1);
	} // end of main
} // end of class
