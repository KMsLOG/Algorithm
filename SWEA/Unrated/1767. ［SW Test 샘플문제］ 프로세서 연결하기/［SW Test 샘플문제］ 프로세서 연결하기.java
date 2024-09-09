import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Core {
    int r;
    int c;

    public Core(int r, int c) {
        this.r = r;
        this.c = c;
    }
}

public class Solution {
    static int N;
    static int[][] map;
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static List<Core> list;
    static int maxCore;
    static int minLen;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N]; // 맵
            list = new ArrayList<>(); // 코어 좌표 저장할 리스트
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if (i > 0 && i < N - 1 && j > 0 && j < N - 1 && map[i][j] == 1) { // 양 끝에 있는 좌표를 제외하고
                        list.add(new Core(i, j));
                    }
                }
            }
            maxCore = 0;
            minLen = Integer.MAX_VALUE;
            dfs(0, 0);
            sb.append("#"+tc+" "+minLen+"\n");
        }
        System.out.print(sb);
    } // end of main

    static void dfs(int index, int count) { // index : 코어 개수 | count : 연결한 코어 개수
        if (index == list.size()) { // 모든 코어 다 돌았으면
            if (count > maxCore) {
                maxCore = count;
                minLen = calculateLength();
            } else if (count == maxCore) {
                minLen = Math.min(minLen, calculateLength());
            }
            return;
        }

        int r = list.get(index).r;
        int c = list.get(index).c;

        for (int d = 0; d < 4; d++) {
            if (check(r, c, d)) { // 연결 가능한 경우
                fill(r, c, d, 2); // 길 연결하기
                dfs(index + 1, count + 1); // 연결 가능한 경우 재귀
                fill(r, c, d, 0); // 길 복원
            }
        }

        dfs(index + 1, count); // 현재 코어를 사용하지 않는 경우
    } // end of dfs

    static boolean check(int r, int c, int d) { // 도로 채울 수 있는지 확인
        while (true) {
            r += dr[d];
            c += dc[d];
            if (r < 0 || r >= N || c < 0 || c >= N) { // 연결 가능한 경우
                return true;
            }
            if (map[r][c] != 0) { // 1이나 2를 만난 경우
                return false;
            }
        }
    } // end of check

    static void fill(int r, int c, int d, int cover) { // 연결 가능한 도로 채우기
        while (true) {
            r += dr[d];
            c += dc[d];
            if (r < 0 || r >= N || c < 0 || c >= N) {
                break;
            }
            map[r][c] = cover;
        }
    } // end of fill

    static int calculateLength() { // 길이 계산
        int length = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 2) {
                    length++;
                }
            }
        }
        return length;
    } // end of calculateLength
} // end of class
