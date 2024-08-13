

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution_SWEA_8931_제로_D3_조강민_210ms {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int tc = 0 ; tc<T;tc++) {
			int k = Integer.parseInt(br.readLine());
			Stack<Integer> stack = new Stack<>();
			for(int i =0 ; i<k;i++) {
				int money = Integer.parseInt(br.readLine());
				if(money == 0) {
					stack.pop();
				} else {
					stack.push(money);
				}
			}
			int sum = 0;
			for(int num : stack) {
				sum+=num;
			}
			sb.append("#"+(tc+1)+" "+sum+"\n");
		}
		System.out.print(sb);
	} // end of main
} // end of class
