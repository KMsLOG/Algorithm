import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static int N,M;
	public static int[] arr;
	public static StringBuilder sb = new StringBuilder();
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] nm = br.readLine().split(" ");
		N = Integer.parseInt(nm[0]);
		M = Integer.parseInt(nm[1]);
		int[] numarr  = new int[N];
		arr = new int[M];
		String s = br.readLine();
		StringTokenizer st = new StringTokenizer(s);
		for(int i = 0 ; i<N;i++) {
			numarr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(numarr);
		dfs(numarr,0);
		System.out.print(sb);
		
	} // end of main
	
	public static void dfs(int[] numarr, int depth) {
		if(depth == M) {
			for(int i : arr) {
				sb.append(i+" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i = 0 ; i<N;i++) {
			arr[depth] = numarr[i];
			dfs(numarr, depth+1);
		}
		
	}
} // end of class
