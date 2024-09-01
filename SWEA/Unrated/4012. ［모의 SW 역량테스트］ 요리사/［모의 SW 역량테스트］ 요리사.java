import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	static int N;
	static int[][] map;
	static List<Integer> a = new ArrayList<>();
	static int half;
	static int min_diff;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc<=T ; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			
			for(int i = 0 ; i<N;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0 ;j<N;j++) {
					int num = Integer.parseInt(st.nextToken());
					map[i][j]+=num;
					map[j][i]+=num;
				}
			}
			half = N/2;
			min_diff = Integer.MAX_VALUE;
			comb(0,half);
			sb.append("#"+tc+" "+min_diff+"\n");
			
		} // end of tc
		System.out.print(sb);
	} // end of main
	
	static void comb(int start, int r) {
		if(r==0) {
			List<Integer> b = new ArrayList<>();
			
			for(int i = 0;i<N;i++) {
				if(!a.contains(i)) {
					b.add(i);
				}
			}
			
			int aSum = 0;
			int bSum = 0;
			
			for(int i = 0 ; i<half;i++) {
				for(int j = i+1 ;j<half;j++) {
					aSum+=map[a.get(i)][a.get(j)];
					bSum+=map[b.get(i)][b.get(j)];
				}
			}
			
			int diff = Math.abs(aSum-bSum);
			min_diff = Math.min(min_diff, diff);
		}
		
		for(int i = start; i<N;i++) {
			a.add(i);
			comb(i+1,r-1);
			a.remove(a.size()-1);
		}
	} // end of comb
} // end of class
