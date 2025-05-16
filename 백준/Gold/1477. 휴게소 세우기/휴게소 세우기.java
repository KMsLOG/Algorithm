import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int[] rest = new int[N + 2];
        rest[0] = 0;
        rest[N + 1] = L;

        if (N > 0) {
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                rest[i] = Integer.parseInt(st.nextToken());
            }
        }

        Arrays.sort(rest);

        int left = 1;
        int right = L - 1;
        int answer = 0;

        while (left <= right) {
            int mid = (left + right) / 2;
            
            int count = 0;
            for (int i = 1; i < rest.length; i++) {
                int dist = rest[i] - rest[i - 1];
                count += (dist - 1) / mid;
            }
            if (count > M) {
                left = mid + 1;

            } else {
                answer = mid;
                right = mid - 1;
            }
        }
        System.out.println(answer);
    } // end of main
} // end of class\

