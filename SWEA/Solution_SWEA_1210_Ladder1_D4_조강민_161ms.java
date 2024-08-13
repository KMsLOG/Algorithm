import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_1210_Ladder1_D4_조강민_161ms {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int row = 0;
		int col = 0;
		// ladder 입력
		for(int tc = 0 ; tc<10;tc++) {
			int T = Integer.parseInt(br.readLine());
			int[][] ladder = new int[100][100];
			for(int i = 0 ; i<100;i++) { 			// 사다리 입력
				String s = br.readLine();
				StringTokenizer st = new StringTokenizer(s);
				for(int j = 0 ; j<100;j++) {
					ladder[i][j] = Integer.parseInt(st.nextToken());
					if(i==99 && ladder[i][j]==2) {	// 도착지 좌표를 row, col에 저장
						row=i;
						col=j;
					}
				}
			}
			
            while (row > 0) { // 도착지에서부터 처음 지점까지 올라가기
                if (col-1 >= 0 && ladder[row][col-1] == 1) { // 좌측에 사다리 길이 있으면
                    while (col-1 >= 0 && ladder[row][col-1] == 1) { // 좌측이 사디리길이 없을때까지
                        col--;										// 쭉 가기
                    }
                } 
                else if (col+1 < 100 && ladder[row][col+1] == 1) { // 우측에 사디리 길이 있으면
                    while (col+1 < 100 && ladder[row][col+1] == 1) { // 우측에 사다리 길이 없을떄가지
                        col++;										// 쭉가기
                    }
                }
                row--;	// 양 옆에 길이 없으면 올라가기
            }
			sb.append("#"+T+" "+col+"\n"); // 최종 도착 col 좌표 sb에 저장
			
		} // end of tc
		System.out.print(sb);	// sb 출력
		br.close();
	} // end of main
} // end of class
