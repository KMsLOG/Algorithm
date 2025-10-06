import java.io.*;
import java.util.*;

public class Main {
    static int L, C;
    static StringBuilder sb = new StringBuilder();
    static String[] s;
    static Set<String> vowel;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        s = new String[C];
        vowel = new HashSet<>(Arrays.asList("a", "e", "i", "o", "u"));

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            s[i] = st.nextToken();
        }

        Arrays.sort(s);

        comb(0, 0, 0, 0, "");

        System.out.print(sb);
    } // end of main

    static void comb(int start, int vCnt, int cCnt, int depth, String word) {
        if (depth == L) {
            if (vCnt >= 1 && cCnt >= 2) {
                sb.append(word).append("\n");
            }
            return;
        }

        for (int i = start; i < C; i++) {
            String cur= s[i];
            if (vowel.contains(cur)) {
                comb(i + 1, vCnt + 1, cCnt, depth + 1, word + cur);
            } else {
                comb(i + 1, vCnt, cCnt + 1, depth + 1, word + cur);
            }
        }
    } // end of comb
}
