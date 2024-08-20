import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[100001];
		int maxCnt = 0;
		Queue<Integer> q = new LinkedList<>();
		int num0 = Integer.parseInt(st.nextToken());
		q.add(num0);
		arr[num0]++;
		for(int i = 1 ; i<N;i++) {
			int num = Integer.parseInt(st.nextToken());
			if(arr[num]+1>K) {
				if(maxCnt<q.size()) {
					maxCnt = q.size();
				}
				while(true) {
					if(q.peek()!=num) {
						arr[q.peek()]--;
						q.poll();
					} else {
						q.poll();
						break;
					}
				}
				q.add(num);
			} else {
				q.add(num);
				arr[num]++;
			}
			
		}
		
		if(maxCnt < q.size()) {
			maxCnt= q.size();
		}
		System.out.println(maxCnt);
	} // end of main
} // end of class
