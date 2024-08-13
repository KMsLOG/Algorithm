import java.util.Scanner;

public class Solution_SWEA_1217_거듭제곱_D3_조강민_138ms {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		for(int tc = 1 ; tc<=10; tc++) {
			int T = sc.nextInt();
			int N = sc.nextInt();
			int M = sc.nextInt();
			System.out.println("#"+tc+" "+sqr(N,M));
		}
	} // end of main
	static int sqr(int N, int M) {
		if(M == 1) {
			return N;
		} else {
			return N*sqr(N,M-1);
		}
	}
} // end of class
