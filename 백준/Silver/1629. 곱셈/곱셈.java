import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        System.out.println(dfs(A, B, C));
    }

    static long dfs(int A, int B, int C) {
        if (B == 0) return 1;
        if (B == 1) return A % C;

        long half = dfs(A, B / 2, C);
        long result = (half * half) % C;

        if (B % 2 == 1) {
            result = (result * A) % C;
        }

        return result;
    }
}
