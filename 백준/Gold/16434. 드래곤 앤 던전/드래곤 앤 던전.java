import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int ATK = Integer.parseInt(st.nextToken());
        long left = 1;
        long right = Long.MAX_VALUE;
        long answer = 0;
        List<int[]> games = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            games.add(new int[]{t, a, h});
        }

        while (left <= right) {
            long maxHp = left + (right - left) / 2;
            long currentHp = maxHp;
            long currentAtk = ATK;
            boolean isDead = false;

            for (int[] game : games) {
                int type = game[0];
                int a = game[1];
                int h = game[2];

                if (type == 1) {
                    long cnt = (h + currentAtk - 1) / currentAtk;
                    currentHp -= (cnt - 1) * a;
                    if (currentHp <= 0) {
                        isDead = true;
                        break;
                    }
                } else {
                    currentAtk += a;
                    currentHp = Math.min(maxHp, currentHp + h);
                }
            }

            if (isDead) {
                left = maxHp + 1;
            } else {
                answer = maxHp;
                right = maxHp - 1;
            }
        }
        System.out.println(answer);
    }
}
