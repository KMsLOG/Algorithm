import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            String order = br.readLine();
            int N = Integer.parseInt(br.readLine());
            Deque<Integer> deque = new ArrayDeque<>();
            String s = br.readLine();

            // 리스트에 값 넣기
            s = s.substring(1, s.length() - 1); // [] 제거
            if (!s.isEmpty()) {
                String[] nums = s.split(",");
                for (String num : nums) {
                    deque.addLast(Integer.parseInt(num));
                }
            }

            // 계산
            boolean flag = true;
            boolean isReversed = false;

            loop: for (int i = 0; i < order.length(); i++) {
                char o = order.charAt(i);
                if (o == 'R') {
                    isReversed = !isReversed;
                } else {
                    if (deque.isEmpty()) {
                        flag = false;
                        break loop;
                    } else {
                        if (isReversed) {
                            deque.removeLast();
                        } else {
                            deque.removeFirst();
                        }
                    }
                }
            }

            if (flag) {
                sb.append("[");
                if (isReversed) {
                    while (!deque.isEmpty()) {
                        sb.append(deque.removeLast());
                        if (!deque.isEmpty()) sb.append(",");
                    }
                } else {
                    while (!deque.isEmpty()) {
                        sb.append(deque.removeFirst());
                        if (!deque.isEmpty()) sb.append(",");
                    }
                }
                sb.append("]\n");
            } else {
                sb.append("error\n");
            }
        }
        System.out.println(sb);
    } // end of main
} // end of class
