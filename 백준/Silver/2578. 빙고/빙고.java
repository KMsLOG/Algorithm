import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static boolean[][] answer = new boolean[5][5]; // 빙고를 확인할 5X5 boolean 배열
	static int[][] bingo = new int[5][5]; // 5X5 빙고판
	static int bingocnt = 0; // 빙고 갯수를 세주는 cnt
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i = 0 ; i<5;i++) {	// 빙고판에 숫자 입력
			String s = br.readLine();
			StringTokenizer st = new StringTokenizer(s);
			for(int j = 0 ;j<5 ;j++) {
				bingo[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int numcnt = 0;	// 사회자가 몇 번째 수를 불렀는지 알 수 있는 numcnt
		while(numcnt<=25) {	// 25번 부를 때 까지
			String s = br.readLine();
			StringTokenizer st = new StringTokenizer(s);
			boolean ok = false;	// bingo를 확인하는 boolean
			for(int i = 0 ; i<5;i++) {
				int number = Integer.parseInt(st.nextToken()); // 사회자가 부르는 수
				numcnt++;	// numcnt 1 더하기
				if(findBingo(number)) { // 빙고가 3개 이상 완성됬으면 true
					ok = true;			// 완성됬음을 확인
					break;
				}
			}
			if(ok) {
				System.out.println(numcnt); // numcnt 출력
				break;	// 반복문 종료
			}
		}
	} // end of main
	
	// 빙고인지 아닌지 확인하는 클래스
	static boolean findBingo(int number) {
		int r = 0; // number의 행
		int c = 0; // number의 열
		
		// number의 위치 찾기 & 위치 표시하기
		for(int i = 0 ; i<5;i++) {
			for(int j = 0 ; j<5;j++) {
				if(bingo[i][j]==number) { // 사회자가 부른 수랑 빙고판의 수랑 매칭
					r = i;
					c = j;
					answer[i][j] = true; //빙고판의 수의 위치를 빙고를 확인할 5X5 boolean 배열의 위치에 표시
					break;
				}
			}
		}
		
		boolean flag = true; // 빙고인지 아닌지 확인해주는 boolean
		
		// 가로찾기
		for(int i = 0 ; i<5;i++) {
			if(answer[r][i] == false) { // 해당 위치 가로행의 수 중 표시가 안되어 있는 것을 확인
				flag = false;			// bingo가 아니다
				break;					// 반복문 탈출
			}
		}
		if(flag==true) {				// 전부 표시 되어있으면
			bingocnt++;					// 빙고 카운트 하나 증가
		}
		
		// 세로찾기
		flag = true;					// flag 초기화
		for(int i = 0 ; i<5;i++) {
			if(answer[i][c] == false) {	// 해당 위치 세로열의 수 중 표시가 안되어 있는 것을 확인
				flag = false;			// bingo가 아니다
				break;					// 반복문 탈출
			}
		}
		if(flag==true) {				// 전부 표시 되어있으면
			bingocnt++;					// 빙고 카운트 하나 증가
		}		
		
		
		// 정방향 대각선 찾기 (대각선 되는 경우)
		flag = true;					// flag 초기화
		if(r == c) {					// 행 열 위치가 같은 경우만 왼쪽 위에서 오른쪽 아래로 오는 대각선
			for(int i=0;i<5;i++) {
				if(answer[i][i] == false) {	// 해당위치 정방향 대각선의 수 중 표시가 안되어 있는 것을 확인
					flag = false;			// bingo가 아니다
					break;					// 반복문 탈출
				}
			}
		} else {							// flag 초기화한채로 진행하면 bingo카운트가 늘어나기 때문에 false로 바꾸기 위한 코드
			flag = false;					// ...
		}
		
		if(flag==true) {				// 정방향 대각선에 다 표시가 되어있으면
			bingocnt++;					// 빙고 카운트 하나 증가
		}
		
		// 역방향 대각선 찾기 (대각선 되는 경우)
		flag=true;						// flag 초기화
		if((r==0 && c==4)||(r==1 && c==3)||(r==2 && c==2)||(r==3 && c==1)||(r==4 && c==0)) {	// 역방향 대각선인 경우 / 왼쪽 아래에서 오른쪽 위로 가는 대각선
			for(int i = 0, j=4 ;i<5;i++,j--) {	// 해당위치 역방향 대각선의 수 중 표시가 안되어 있는 것을 확인
				if(answer[i][j]==false) {	// 해당위치 역방향 대각선의 수 중 표시가 안되어 있는 것을 확인
					flag = false;	// bingo가 아니다
					break;			// 반복문 탈출
				}
			}
		} else {					// flag 초기화한채로 진행하면 bingo카운트가 늘어나기 때문에 false로 바꾸기 위한 코드
			flag = false;			// ...
		}
		
		if(flag==true) {			// 역방향 대각선에 다 표시가 되어있으면
			bingocnt++;				// 빙고 카운트 하나 증가
		}
		
		
		if(bingocnt>=3) {	// 빙고가 3개 이상이면
			return true;	// true 반환
		}
		return false;		// 3개 미만이면 false 반환
		
	} // end of findBingo
} // end of class
