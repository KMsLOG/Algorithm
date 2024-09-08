import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static long a,b;
	static int cnt = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		a = Long.parseLong(st.nextToken());
		b = Long.parseLong(st.nextToken());
		
		System.out.println(bfs());
	} // end of main
	
	static int bfs() {
		Queue<Long>q = new LinkedList<>();
		
		q.add(a);
		while(!q.isEmpty()) {
			int size = q.size();
			for(int i = 0 ; i<size;i++) {
				long cur = q.poll();
				
				if(cur == b) {
					cnt++;
					return cnt;
				}
				if(cur*2<=b) {
					q.add(cur*2);
				}
				if(cur*10+1<=b) {
					q.add(cur*10+1);
				}
			}
			cnt++;
		}
		return -1;
	} // end of bfs
} // end of class
