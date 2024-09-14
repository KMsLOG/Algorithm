import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static long[] tri;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		tri = new long[101];
		tri[1] = 1;
		tri[2] = 1;
		tri[3] = 1;
		for(int t = 0 ; t<T;t++) {
			int N = Integer.parseInt(br.readLine());
			long result = get(N);
			sb.append(result+"\n");
		}
		System.out.print(sb);
	} // end of main
	static long get(int N) {
		if(tri[N]==0) {
			tri[N] = get(N-2)+get(N-3);
		}
		return tri[N];
	}
} // end of class
