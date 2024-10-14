import java.util.*;

public class Main {
    static List<String> results = new ArrayList<>();
    static String[] ds = {"+", "-", " "};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            int num = sc.nextInt();
            dfs(1, num, "1");
            Collections.sort(results); // 결과를 아스키 코드 순으로 정렬
            for (String result : results) {
                System.out.println(result);
            }
            results.clear(); // 다음 케이스를 위해 결과 리스트 초기화
            System.out.println(); // 각 케이스 사이에 빈 줄 추가
        }
    } // end of main

    static void dfs(int start, int num, String s) {
        if (start == num) {
            int tmpsum = calculate(s);
            if (tmpsum == 0) {
                results.add(s); // 결과 리스트에 추가
            }
            return;
        }

        for (String d : ds) {
            String newS = s + d + (start + 1);
            dfs(start + 1, num, newS);
        }
    } // end of dfs

    static int calculate(String s) {
        int sum = 0;
        String num = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            if (i == s.length() - 1) {
                num += s.charAt(i);
            } else if (i == 0) {
                num = s.charAt(i) + num;
                sum += Integer.parseInt(num);
            } else {
                char c = s.charAt(i);
                if (Character.isDigit(c)) {
                    num = c + num;
                } else if (c == '+') {
                    sum += Integer.parseInt(num);
                    num = "";
                } else if (c == '-') {
                    sum -= Integer.parseInt(num);
                    num = "";
                } else if (c == ' ') {
                    continue;
                }
            }
        }
        return sum;
    } // end of calculate
} // end of class
