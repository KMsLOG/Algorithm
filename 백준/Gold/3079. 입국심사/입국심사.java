import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        long M = Long.parseLong(st.nextToken());

        long[] simsa = new long[N];
        for (int i = 0; i < N; i++) {
            simsa[i] = Long.parseLong(br.readLine());
        }

        Arrays.sort(simsa);

        long left = 0;
        long right = simsa[N - 1] * M;
        long answer = right;

        while (left <= right) {
            long mid = (left + right) / 2;
            long cnt = 0;

            for (long s : simsa) {
                cnt += mid / s;
                if (cnt >= M) break;
            }

            if (cnt >= M) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(answer);
    }
}
