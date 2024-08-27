import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N, K;
    static List<Integer> robot;
    static List<Integer> convey;
    static int time = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        robot = new LinkedList<>();
        convey = new LinkedList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 2 * N; i++) {
            convey.add(Integer.parseInt(st.nextToken()));
        }

        for (int i = 0; i < N; i++) {
            robot.add(0);
        }
        move();
        System.out.println(time);
    }

    static void move() {
        while (true) {
            time++;
            // 1단계: 컨베이어 벨트와 로봇 이동
            int lastConvey = convey.remove(convey.size() - 1);
            convey.add(0, lastConvey);

            int lastRobot = robot.remove(robot.size() - 1);
            robot.add(0, lastRobot);

            // 마지막 위치의 로봇이 있으면 내려준다
            if (robot.get(N - 1) == 1) {
                robot.set(N - 1, 0);
            }

            // 2단계: 로봇 이동
            for (int i = N - 2; i >= 0; i--) {
                if (robot.get(i) == 1 && robot.get(i + 1) == 0 && convey.get(i + 1) > 0) {
                    robot.set(i + 1, 1);
                    robot.set(i, 0);
                    convey.set(i + 1, convey.get(i + 1) - 1);
                    // 마지막 위치의 로봇이 있으면 내려준다
                    if (robot.get(N - 1) == 1) {
                        robot.set(N - 1, 0);
                    }
                }
            }

            // 3단계: 로봇 배치
            if (convey.get(0) > 0) {
                robot.set(0, 1);
                convey.set(0, convey.get(0) - 1);
            }

            // 4단계: 내구도가 0인 칸의 개수 카운트
            int cnt = 0;
            for (int i : convey) {
                if (i == 0) {
                    cnt++;
                }
            }
            if (cnt >= K) {
                break;
            }
        }
    }
}
