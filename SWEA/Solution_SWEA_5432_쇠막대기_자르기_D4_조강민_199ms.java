

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution_SWEA_5432_쇠막대기_자르기_D4_조강민_199ms {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
        for(int tc = 0; tc < T; tc++) {
            int total = 0;
            String s = br.readLine();
            char[] charArray = s.toCharArray();
            Stack<Character> stack = new Stack<>();
             
            for(int j = 0; j < charArray.length; j++) {
                if(charArray[j] == ')' && charArray[j - 1] == '(') {
                    stack.pop();
                    total += stack.size();
                } else if (charArray[j] == ')') {
                    stack.pop();
                    total ++;
                }
                else {
                    stack.push(charArray[j]);
                }
            }
             
            sb.append("#"+(tc+1)+" "+total+"\n");
        } // end of tc
        System.out.print(sb);
    } // end of main
} // end of class
