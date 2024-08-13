import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_SWEA_4163_러시아국기같은깃발_D4_조강민_124ms {
	public static void main(String[] args) throws  IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1 ; tc<=T ;tc++) {
			String[] s = br.readLine().split(" ");
			int N = Integer.parseInt(s[0]);
			int M = Integer.parseInt(s[1]);
			int[][] cnt = new int[N][3];
			
			for(int i = 0 ; i<N;i++) {
				String color = br.readLine();
				for(int j = 0 ; j<color.length();j++) {
					char c = color.charAt(j);
					if(c == 'W') {
						cnt[i][0]++;
					} else if(c == 'B') {
						cnt[i][1]++;
					} else {
						cnt[i][2]++;
					}
				}
			}
			
			int white = 0;
			int blue = 0;
			int red = 0;
			int min = Integer.MAX_VALUE;
			for(int w = 0 ; w< cnt.length-2;w++) {
				white = white + cnt[w][1]+cnt[w][2];
				blue = 0;
				for(int b = w+1;b<cnt.length-1;b++) {
					blue = blue + cnt[b][0]+cnt[b][2];
					red = 0;
					for(int r = b+1;r<cnt.length;r++) {
						red = red + cnt[r][0]+cnt[r][1];
					}
					min = Math.min(min, white+blue+red);
				}
			}
			sb.append("#"+tc+" "+min+"\n");
			
		} // end of tc
		System.out.print(sb);
	} // end of main
} // end of class
