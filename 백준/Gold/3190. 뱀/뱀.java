import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[][] board;
    static Map<Integer, Character> directions = new HashMap<>();

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        board = new int[N + 1][N + 1];

        int K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            board[x][y] = 1;
        }

        int L = Integer.parseInt(br.readLine());
        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            char dir = st.nextToken().charAt(0);
            directions.put(time, dir);
        }

        System.out.println(simulation());
    }

    static int simulation() {
        Deque<int[]> snake = new ArrayDeque<>();
        snake.add(new int[]{1, 1});
        board[1][1] = 2;

        int dir = 0;
        int time = 0;

        while (true) {
            time++;

            int[] head = snake.peekFirst();
            int nx = head[0] + dx[dir];
            int ny = head[1] + dy[dir];

            if (nx < 1 || ny < 1 || nx > N || ny > N) {
                break;
            }

            if (board[nx][ny] == 2) {
                break;
            }

            snake.addFirst(new int[]{nx, ny});

            if (board[nx][ny] == 1) {
                board[nx][ny] = 2;
            } else {
                board[nx][ny] = 2;
                int[] tail = snake.removeLast();
                board[tail[0]][tail[1]] = 0;
            }

            if (directions.containsKey(time)) {
                char c = directions.get(time);
                if (c == 'L') {
                    dir = (dir + 3) % 4;
                } else {
                    dir = (dir + 1) % 4;
                }
            }
        }

        return time;
    }
}
