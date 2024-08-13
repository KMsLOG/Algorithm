import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean[][] map = new boolean[101][101];
		int x1;
		int y1;
		int x2;
		int y2;
		for(int k = 0 ; k<4 ;k ++) {
			String s = br.readLine();
			StringTokenizer st = new StringTokenizer(s);
			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());
			
			for(int i = x1;i<x2;i++) {
				for(int j = y1; j<y2;j++) {
					map[i][j] = true;
				}
			}
		}
		int sqr = 0;
		for(int i = 0 ; i<101;i++) {
			for(int j = 0 ;j<101;j++) {
				if(map[i][j]) {
					sqr++;
				}
			}
		}
		
		System.out.println(sqr);
	} // end of main
} // end of class
