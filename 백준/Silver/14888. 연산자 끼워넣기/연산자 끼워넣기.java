import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] number;
	static int[] oper;
	static int min = Integer.MAX_VALUE;
	static int max = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws  IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		number = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0 ;i<N;i++) {
			number[i] = Integer.parseInt(st.nextToken());
		}
		oper = new int[4];
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i<4;i++) {
			oper[i] = Integer.parseInt(st.nextToken());
		}
		
		dfs(number[0],1);
		System.out.println(max);
		System.out.println(min);
	} // end of main
	
	static void dfs(int num , int idx) {
		if(idx == N) {
			min = Math.min(min, num);
			max = Math.max(max, num);
			return;
		}
		
		for(int i = 0 ;i<4;i++) {
			if(oper[i]>0) {
				oper[i]--;
				if(i == 0) {
					dfs(num+number[idx],idx+1);
				} else if(i == 1) {
					dfs(num-number[idx],idx+1);
				} else if(i == 2) {
					dfs(num*number[idx],idx+1);
				} else {
					dfs(num/number[idx],idx+1);
				}
				oper[i]++;
			}
		}
		
	} // end of dfs
} // end of class
