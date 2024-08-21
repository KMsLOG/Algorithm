import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String first = br.readLine();
		String second = br.readLine();
		int firstLen = first.length();
		int secondLen = second.length();
		
		
		
		char[] firstArr = new char[firstLen+1];
		char[] secondArr = new char[secondLen+1];
		
		int[][] dp = new int[firstLen+1][secondLen+1];
		
		for(int i = 1; i<=firstLen ; i++) {
			firstArr[i] = first.charAt(i-1);
		}
		for(int i = 1 ; i<=secondLen; i++) {
			secondArr[i] = second.charAt(i-1);
		}
		
		for(int i = 1 ; i<=firstLen;i++) {
			for(int j=1;j<=secondLen;j++) {
				if(firstArr[i] == secondArr[j]) {
					dp[i][j] = dp[i-1][j-1]+1;
				} else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		
		System.out.println(dp[firstLen][secondLen]);
	} // end of main
} // end of class
