import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class Cal {
    int num;
    String s;

    public Cal(int num, String s) {
        this.num = num;
        this.s = s;
    }
}

public class Main {
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int answer = Integer.parseInt(st.nextToken());
            visited = new boolean[10000];
            String result = bfs(start, answer);
            sb.append(result).append("\n");
        }

        System.out.print(sb);
    }

    // BFS
    static String bfs(int start, int answer) {
        Queue<Cal> q = new ArrayDeque<>();
        q.add(new Cal(start, ""));
        visited[start] = true;

        while (!q.isEmpty()) {
            Cal cur = q.poll();
            if (cur.num == answer) return cur.s;

            int[] nextNums = {
                    doD(cur.num),
                    doS(cur.num),
                    doL(cur.num),
                    doR(cur.num)
            };
            char[] ops = {'D', 'S', 'L', 'R'};

            for (int i = 0; i < 4; i++) {
                int newNum = nextNums[i];
                if (!visited[newNum]) {
                    visited[newNum] = true;
                    q.add(new Cal(newNum, cur.s + ops[i]));
                }
            }
        }

        return "answer"; // 도달 불가한 경우 (문제상 나오지 않음)
    }

    // D
    static int doD(int num) {
        return (num * 2) % 10000;
    }

    // S
    static int doS(int num) {
        return (num == 0) ? 9999 : num - 1;
    }

    // L
    static int doL(int num) {
        return (num % 1000) * 10 + num / 1000;
    }

    // R
    static int doR(int num) {
        return (num % 10) * 1000 + num / 10;
    }
}
