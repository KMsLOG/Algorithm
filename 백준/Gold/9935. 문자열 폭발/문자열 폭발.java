import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String bomb = br.readLine();

        int bombLen = bomb.length();
        StringBuilder stack = new StringBuilder();

        // 앞에서부터 시작
        for (int i = 0; i < s.length(); i++) {
            stack.append(s.charAt(i));
            if (stack.length() >= bombLen) {
                boolean isBomb = true;
                for (int j = 0; j < bombLen; j++) {
                    if (stack.charAt(stack.length() - bombLen + j) != bomb.charAt(j)) {
                        isBomb = false;
                        break;
                    }
                }

                // 폭발 문자열 제거
                if (isBomb) {
                    stack.setLength(stack.length() - bombLen);
                }
            }
        }

        // 결과 출력
        if (stack.length() == 0) {
            System.out.println("FRULA");
        } else {
            System.out.println(stack);
        }
    } // end of main
} // end of class