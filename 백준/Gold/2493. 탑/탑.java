import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;


public class Main {
	static class Top{
		int height;
		int idx;
		public Top(int height, int idx) {
			this.height = height;
			this.idx = idx;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb= new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		Stack<Top> stack = new Stack<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i =1 ; i<=N ;i++) {
			int height = Integer.parseInt(st.nextToken());
			while(true) {
				if(stack.isEmpty()) {
					sb.append(0+" ");
					break;
				} else if(stack.peek().height<=height) {
					stack.pop();
					
				} else if(stack.peek().height>height) {
					sb.append(stack.peek().idx+" ");
					break;
				}
				
			}
			
			stack.push(new Top(height,i));
		}
		System.out.print(sb);
	} // end of main
} // end of class
