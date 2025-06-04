import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int Num = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];

        int[] dr = {1, 0, -1, 0};
        int[] dc = {0, 1, 0, -1};
        int[] co = new int[2];
        int start = N * N;
        int r = 0;
        int c = 0;
        int d = 0;

        while (start > 0) {
            map[r][c] = start;
            if (start == Num) {
                co[0] = r + 1;
                co[1] = c + 1;
            }
            if (r + dr[d] < 0 || r + dr[d] >= N || c + dc[d] < 0 || c + dc[d] >= N || map[r + dr[d]][c + dc[d]] > 0) {
                d = (d + 1) % 4;
            }
            r = r + dr[d];
            c = c + dc[d];
            start--;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }
        sb.append(co[0]).append(" ").append(co[1]);

        System.out.println(sb);
    } // end of main
} // end of class
