import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Conf implements Comparable<Conf>{
	int start;
	int end;
	public Conf(int start, int end) {
		super();
		this.start = start;
		this.end = end;
	}
	@Override
	public int compareTo(Conf o) {
		if(this.end == o.end) {
			return this.start - o.start;
		}
		return this.end-o.end;
	}
	
}

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Conf> pq = new PriorityQueue<>();
		
		for(int i = 0 ; i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			pq.add(new Conf(start,end));
		}
		
		int cnt = 1;
		int end = pq.poll().end;
		
		
		while(!pq.isEmpty()) {
			Conf cur = pq.poll();
			if(end<=cur.start) {
				end = cur.end;
				cnt++;
			}
		}
		System.out.println(cnt);
	} // end of main
} // end of class
