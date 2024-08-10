import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static boolean[] visit;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		
		int n = Integer.parseInt(s[0]);
		int m = Integer.parseInt(s[1]);
		visit = new boolean[n];
		arr = new int[m];
		dfs(n,m,0);
		System.out.print(sb);
	}
	
	static void dfs(int n, int m, int depth) {
		if(depth == m) {
			for(int num : arr) {
				sb.append(num+" ");
			}
			sb.append("\n");
			return;
		}
		for(int i = 0 ; i<n;i++) {
			if(!visit[i]) {
				visit[i] = true;
				arr[depth] = i+1;
				dfs(n,m,depth+1);
				visit[i] = false;
			}
		}
		
		
	}
}
