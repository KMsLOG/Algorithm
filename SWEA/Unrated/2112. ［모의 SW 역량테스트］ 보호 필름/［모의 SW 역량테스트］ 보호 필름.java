import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static int D,W,K;
	static int[][] map;
	static int ans;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1 ;tc<=T ;tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			map = new int[D][W];
			
			for(int i = 0 ;i<D;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0 ;j<W;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			ans = K;
			
			dfs(0,0);
			
			sb.append("#"+tc+" "+ans+"\n");
		} // end of tc
		System.out.print(sb);
	} // end of main
	
	static void dfs(int idx, int cnt) {
		if(idx == D) {
			if(check()) {
				ans = Math.min(ans, cnt);
			}
			return;
		}
		
		
		
		// 주입 x
		dfs(idx+1,cnt);
		
		int[] tmp = new int[W];
		for(int i = 0 ;i<W;i++) {
			tmp[i] = map[idx][i];
		}
		
		// 주입 a
		for(int i = 0; i<W;i++) {
			map[idx][i] = 0;
		}
		dfs(idx+1,cnt+1);
		// 주입 b
		for(int i = 0; i<W;i++) {
			map[idx][i] = 1;
		}
		dfs(idx+1,cnt+1);
		
		// 원상복구
		for(int i = 0 ; i<W ;i++) {
			map[idx][i] = tmp[i];
		}
		
	} // end of dfs
	
	static boolean check() {
		for(int c = 0 ; c<W;c++) {
			boolean flag = false;
			int cnt = 1;
			
			for(int r = 1; r<D;r++) {
				if(map[r][c] == map[r-1][c]) {
					cnt++;
				} else {
					cnt = 1;
				}
				if(cnt >= K) {
					flag = true;
					break;
				}
			}
			if(!flag) {
				return false;
			}
		}
		
		return true;
	}
} // end of class
