import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		
		int num = 1;
		
		for(int i = 0 ; i<T;i++) {
			int N = Integer.parseInt(br.readLine());
			for(;num<=N;num++) {
				stack.push(num);
				sb.append("+ \n");
			}
			if(stack.peek() == N) {
				stack.pop();
				sb.append("- \n");
			}
			
		}

		
		if(!stack.isEmpty()) {
			System.out.println("NO");
		} else {
			System.out.print(sb);
		}
	} // end of main
} // end of class
