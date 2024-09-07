import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i = 0 ; i<N;i++) {
			pq.add(Integer.parseInt(br.readLine()));
		}
		int max = Integer.MIN_VALUE;
		
		for(int i = N ;i>=1;i--) {
			max = Math.max(max, i*pq.poll());
		}
		System.out.println(max);
	} // end of main
} // end of class
