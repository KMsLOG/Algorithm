import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int maxH = -1;
		int maxIdx = -1;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] map = new int[M];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0 ;i<M ;i++) {
			map[i] = Integer.parseInt(st.nextToken());
			if(map[i]>maxH) {
				maxH = map[i];
				maxIdx = i;
			}
		}
		
		int sum = 0;
		
		// 처음 부터 가장 긴 블록까지
		int prevH = map[0];
		
		for(int i = 1 ;i<=maxIdx;i++) {
			if(prevH<map[i]) {
				prevH = map[i];
			} else {
				sum+=(prevH-map[i]);
			}
		}
		
		// 끝부터 가장 긴 블록까지
		int postH = map[M-1];
		
		for(int i = M-2; i>=maxIdx;i--) {
			if(postH<map[i]) {
				postH = map[i];
			} else {
				sum+=(postH-map[i]);
			}
		}
		
		System.out.println(sum);
	} // end of main
} // end of class
