import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int N;
	static int cnt = 0;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N];
		find(0);
        System.out.println(cnt);
	} // end of main
	
	static void find(int depth) {
		if(depth == N) {
			cnt++;
			return;
		}
		
		for(int j = 0 ; j<N ;j++) {
			arr[depth] = j;
			if(possible(depth)) {
				find(depth+1);
			}
		}
	} // end of find
	static boolean possible(int depth) {
		
		for(int i = 0 ; i<depth;i++) {
			if(arr[i] == arr[depth]) {
				return false;
			} else if(Math.abs(i-depth) == Math.abs(arr[i]-arr[depth])) {
				return false;
			}
		} 
		
		
		return true;
	}
} // end of class
