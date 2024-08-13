import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		boolean[][] dohwaji = new boolean[101][101];
		int cnt = 0;
		for(int n = 0 ;n<N;n++) {
			String s = br.readLine();
			StringTokenizer st = new StringTokenizer(s);
			int c = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			
			for(int i = r ; i<r+10;i++) {
				for(int j = c ; j<c+10;j++) {
					dohwaji[i][j] = true;
				}
			}
		}
		
		int[] dx = {1,0,-1,0};
		int[] dy = {0,1,0,-1};
		
		for(int i = 0 ; i<101;i++) {
			for(int j = 0 ; j<101;j++) {
				if(dohwaji[i][j] == true) {
					for(int d = 0 ; d<4;d++) {
						int nr = i + dx[d];
						int nc = j + dy[d];
						
						if(dohwaji[nr][nc] == false || nr > 100 || nc>100) {
							cnt++;
						}
						
					}
				}
			}
		}
		
		System.out.println(cnt);
		
	} // end of main
} // end of class
