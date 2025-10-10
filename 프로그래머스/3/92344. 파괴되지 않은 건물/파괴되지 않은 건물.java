import java.util.*;

class Solution {
    public int solution(int[][] board, int[][] skill) {
        int n = board.length;
        int m = board[0].length;
        int[][] arr = new int[n + 2][m + 2];

        for (int[] sk : skill) {
            int type = sk[0];
            int r1 = sk[1], c1 = sk[2];
            int r2 = sk[3], c2 = sk[4];
            int degree = (type == 1) ? -sk[5] : sk[5];

            arr[r1 + 1][c1 + 1] += degree;
            arr[r1 + 1][c2 + 2] -= degree;
            arr[r2 + 2][c1 + 1] -= degree;
            arr[r2 + 2][c2 + 2] += degree;
        }

        for (int i = 1; i <= n + 1; i++) {
            for (int j = 1; j <= m + 1; j++) {
                arr[i][j] += arr[i - 1][j] + arr[i][j - 1] - arr[i - 1][j - 1];
            }
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] + arr[i + 1][j + 1] > 0) {
                    answer++;
                }
            }
        }

        return answer;
    }
}
