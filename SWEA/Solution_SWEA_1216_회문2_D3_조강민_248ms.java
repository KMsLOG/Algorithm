import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_SWEA_1216_회문2_D3_조강민_248ms {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for(int tc = 0 ; tc<10;tc++) {
			int T = Integer.parseInt(br.readLine());
			char[][] map = new char[100][100];
		
			for(int i = 0 ; i<100;i++) {
				String s = br.readLine();
				
				map[i] = s.toCharArray();
			}
			
			int maxnum = 0;
			
			// 가로
			for(int cnt = 100 ; cnt>0;cnt--) { // 회문 길이
				for(int x =0 ;x<100;x++) { // 시작 위치
					for(int y = 0 ; y<=100-cnt;y++) {
						boolean yes = false;
						int i = 0;
						while(i<cnt/2) {
							if(map[x][y+i]==(map[x][y+cnt-i-1])){
								i++;
								yes = true;
							} else {
								yes= false;
								break;
							}
						}
						if(yes == true) {
							maxnum=Math.max(maxnum, cnt);
							break;
						}
					}
				} // end of 시작 위치
			} // end of 회문 길이
			
			
			// 세로
			for(int cnt = 100 ; cnt>0;cnt--) { // 회문 길이
				for(int y =0 ;y<100;y++) { // 시작 위치
					for(int x = 0 ; x<=100-cnt;x++) {
						boolean yes = false;
						int i = 0;
						while(i<cnt/2) {
							if(map[x+i][y]==(map[x+cnt-i-1][y])){
								i++;
								yes = true;
							} else {
								yes= false;
								break;
							}
						}
						if(yes == true) {
							maxnum=Math.max(maxnum, cnt);
							break;
						}
					}
				} // end of 시작 위치
			} // end of 회문 길이
			sb.append("#").append(T).append(" ").append(maxnum).append("\n");
		} // end of testcase
		System.out.print(sb);
	} // end of main
} // end of class

