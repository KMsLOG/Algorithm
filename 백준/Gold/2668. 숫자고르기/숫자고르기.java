import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Main {
	static int n, num;
    static int[] arr;
    static boolean[] check;
    static List<Integer> answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        check = new boolean[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine()) - 1;
        }
        answer = new LinkedList<>(); // 답은 가변적이므로 리스트로 선언

        for (int i = 0; i < N; i++) {
            check[i] = true;
            num = i;
            dfs(i);
            check[i] = false;
        }
        Collections.sort(answer);
        System.out.println(answer.size());
        for (Integer integer : answer) {
            System.out.println(integer + 1);
        }
    }

    public static void dfs(int i) {
        if (arr[i] == num) { // 한바퀴돌아 다시 제자리로 돌아오는지 체크
            answer.add(num); // 돌아온다면 정답에 추가
        }
        if (!check[arr[i]]) {
            check[arr[i]] = true;
            dfs(arr[i]);
            check[arr[i]] = false;
        }
    }
}
