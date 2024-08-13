import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution_SWEA_1224_계산기3_D4_조강민_125ms {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for(int tc = 1 ; tc<=10;tc++) {
			int N = Integer.parseInt(br.readLine());
			String infix = br.readLine();
			String postfix = infixToPostfix(infix);
			int result = evalPostfix(postfix);
			sb.append("#"+tc+" "+ result +"\n");
		} // end of tc
		System.out.print(sb);
	} // end of main
	
	static Map<Character,Integer> map = new HashMap<>();
	static {
		map.put('+', 0);
		map.put('*', 1);
	}
	
	public static String infixToPostfix(String infix) {
		Stack<Character> stack = new Stack<>();
		String postfix = "";
		for(int i = 0 ; i<infix.length();i++) {
			char c = infix.charAt(i);
			
			if(c>='0' && c<= '9') {
				postfix+=c;
			} else if(c == '(') {
				stack.push(c);
			} else if(c == ')') {
				char popItem = stack.pop();
				while(popItem!='(') {
					postfix+=popItem;
					popItem = stack.pop();
				}
			} else {
				while(!stack.isEmpty()&& stack.peek() !='('&& map.get(stack.peek()) >= map.get(c)) {
					postfix += stack.pop();
				}
				stack.push(c);
			}
		}
		return postfix;
	} // end of infixToPostfix
	
	public static int evalPostfix(String postfix) {
		Stack<Integer> stack = new Stack<>();
		for(int i = 0 ; i<postfix.length();i++) {
			char c = postfix.charAt(i);
			
			if(c>='0' && c<='9') {
				stack.push(c-'0');
			} else {
				int num1 = stack.pop();
				int num2 = stack.pop();
				int result;
				if(c == '*') {
					result = num1*num2;
				} else {
					result = num1+num2;
				}
				stack.push(result);
			}
		}
		return stack.peek();
	} // end of evalPostfix
} // end of class
