import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_1974_스도쿠검증_D2_조강민_112ms {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1 ;tc<=T ; tc++) {
			int result = 1;
			int[][] sudoku = new int[9][9];
			boolean flag =true;
			
			// 스도쿠에 숫자 입력 & 가로 확인
			for(int i = 0 ; i<9;i++) {
				String s = br.readLine();
				StringTokenizer st = new StringTokenizer(s);
				int[] horcnt = new int[10];
				boolean horflag = true;
				for(int j = 0 ; j<9;j++) {
					int num = Integer.parseInt(st.nextToken());
					sudoku[i][j] = num;
					horcnt[num]++;
					if(horcnt[num]>1) {
						horflag = false;
					}
				}
				if(!horflag) {
					flag = false;
				}
			}
			
			// 세로확인
			for(int j = 0 ; j<9;j++) {
				int[] vercnt = new int[10];
				boolean verflag = true;
				for(int i = 0 ; i<9;i++) {
					vercnt[sudoku[i][j]]++;
					if(vercnt[sudoku[i][j]]>1) {
						verflag = false;
						break;
					}
				}
				if(!verflag) {
					flag = false;
					break;
				}
			}
			
			// 사각형 확인
			for(int i = 0 ; i<9 ; i+=3) {
				for(int j = 0; j<9;j+=3) {
					int[] sqrcnt = new int[10];
					boolean sqrflag = true;
					for(int y=0 ; y <3;y++) {
						for(int x=0;x<3;x++) {
							sqrcnt[sudoku[i+y][j+x]]++;
							if(sqrcnt[sudoku[i+y][j+x]]>1) {
								sqrflag= false;
								break;
							}
						}
					}
					if(!sqrflag) {
						flag = false;
						break;
					}
				}
			}
			
			
			
			if(!flag) {
				result = 0;
			}
			
			sb.append("#"+tc+" "+result+"\n");
		} // end of tc
		System.out.print(sb);
	} // end of main
} // end of class
