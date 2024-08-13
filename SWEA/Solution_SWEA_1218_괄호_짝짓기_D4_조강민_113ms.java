

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution_SWEA_1218_괄호_짝짓기_D4_조강민_113ms {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for(int tc = 0 ; tc<10;tc++) {
			Stack<String> stack = new Stack<>();
			int len = Integer.parseInt(br.readLine());
			String[] bracket = br.readLine().split("");
			boolean flag = true;
			int n = 0;
			for(int i = 0 ; i<len;i++) {
				String b = bracket[i];
				switch (b) {
					case "[" :
						stack.push(b);
						break;
					case "{" :
						stack.push(b);
						break;
					case "(" :
						stack.push(b);
						break;
					case "<" :
						stack.push(b);
						break;
					case "]" :
						if(stack.peek().equals("[")) {
							stack.pop();
							break;
						} else {
							flag = false;
							break;
						}
					case "}" :
						if(stack.peek().equals("{")) {
							stack.pop();
							break;
						} else {
							flag = false;
							break;
						}
					case ")" :
						if(stack.peek().equals("(")) {
							stack.pop();
							break;
						} else {
							flag = false;

							break;
						}
					case ">" :
						if(stack.peek().equals("<")) {
							stack.pop();
							break;
						} else {
							flag = false;

							break;
						}
				} // end of switch
				if(!flag) {
					break;
				}
				} // end of for
			if(flag && stack.isEmpty()) {
				n = 1;
			}
			sb.append("#"+(tc+1)+" "+n+"\n");
		} // end of tc
		System.out.print(sb);
	} // end of main
} // end of class
