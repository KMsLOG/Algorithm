import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = new int[4][8];

        // 톱니바퀴 상태 입력 받기
        for (int i = 0; i < 4; i++) {
            String s = br.readLine();
            for (int j = 0; j < 8; j++) {
                arr[i][j] = s.charAt(j) - '0';
            }
        }

        // 회전 명령 처리
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()) - 1;
            int dir = Integer.parseInt(st.nextToken());
            // 회전 처리
            boolean[] rotated = new boolean[4]; // 각 톱니바퀴의 회전 여부를 기록
            rotate(start, dir, rotated);
        }

        // 톱니바퀴의 점수 계산
        int result = 0;
        for (int i = 0; i < 4; i++) {
            if (arr[i][0] == 1) {
                result += (1 << i); 
            }
        }
        
        System.out.println(result);
    }

    static void rotate(int i, int dir, boolean[] rotated) {
        if (rotated[i]) {
        	return; 
        }
        rotated[i] = true; 


        // 연쇄 회전
        // 좌
        if (i > 0 && !rotated[i - 1] && arr[i][6] != arr[i - 1][2]) {
            rotate(i - 1, dir*(-1), rotated);
        }
        // 우
        if (i < 3 && !rotated[i + 1] && arr[i][2] != arr[i + 1][6]) {
            rotate(i + 1, dir*(-1), rotated);
        }
     // 톱니바퀴 회전
        if (dir == -1) { // 반시계 방향
            int tmp = arr[i][0];
            for (int j = 0; j < 7; j++) {
                arr[i][j] = arr[i][j + 1];
            }
            arr[i][7] = tmp;
        } else if (dir == 1){ // 시계 방향
            int tmp = arr[i][7];
            for (int j = 7; j > 0; j--) {
                arr[i][j] = arr[i][j - 1];
            }
            arr[i][0] = tmp;
        }
    }
}
