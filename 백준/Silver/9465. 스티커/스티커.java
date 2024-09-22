import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] arr = new int[2][N];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 0 ; tc<T ;tc++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[2][N];
			for(int i = 0 ;i<2;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0 ;j<N ;j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int j = 0 ; j<N ;j++) {
				for(int i = 0 ;i<2 ;i++) {
					check(i,j);
				}
			}
			int max = Math.max(arr[0][N-1],arr[1][N-1]);
			sb.append(max+"\n");
		} // end of tc
		System.out.println(sb);
	} // end of main
	
	static void check(int i, int j) {
		if(j == 0) {
			return; 
		} else if (j==1) {
			arr[i][j] += arr[(i+1)%2][j-1];
		} else {
			if(i == 0) {
				arr[i][j] += Math.max(Math.max(arr[1][j-1],arr[1][j-2]),arr[0][j-2]);
			} else {
				arr[i][j] += Math.max(Math.max(arr[0][j-1],arr[1][j-2]),arr[0][j-2]);
			}
		}
	}
} // end of class
