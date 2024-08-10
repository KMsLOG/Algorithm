import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int N,M;
	public static int[] arr;
	public static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[M];
		dfs(0);
		System.out.print(sb);
	} // end of main
	
	public static void dfs(int depth) {
		if(depth == M) {
			for(int num : arr) {
				sb.append(num+" ");
			}
			sb.append("\n");
			return;
		}
		for(int i = 1;i<=N;i++) {
			arr[depth] = i;
			dfs(depth+1);
		}
	}
} // end of class