import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static long INF = Integer.MAX_VALUE;
	static int N,M;
	static long[][] graph;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		graph = new long[N+1][N+1];
		
		for(int i = 0 ;i<=N ;i++) {
			for(int j = 0 ;j<=N;j++) {
				if(i==j) continue;
				graph[i][j] = INF;
			}
		}
		
		for(int i = 0 ; i<M ;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			graph[start][end] = Math.min(graph[start][end], cost);
		}
		floyd();
		for(int i = 1 ; i<=N ;i++) {
			for(int j = 1 ; j<=N ;j++) {
				if(graph[i][j]==INF) {
					System.out.print(0+" ");
				} else {
					System.out.print(graph[i][j]+" ");
				}
			}
			System.out.println();
		}
	} // end of main
	static void floyd() {
		for(int k = 1 ; k<=N ;k++) {
			for(int i = 1 ; i<=N ;i++) {
				for(int j = 1 ; j<=N ;j++) {
					graph[i][j] = Math.min(graph[i][j], graph[i][k]+graph[k][j]);
				}
			}
		}
	}
} // end of class
