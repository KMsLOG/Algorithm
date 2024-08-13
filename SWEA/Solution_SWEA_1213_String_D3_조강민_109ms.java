import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Solution_SWEA_1213_String_D3_조강민_109ms {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb= new StringBuilder();
		for(int tc = 0;tc<10;tc++) {
			int T = Integer.parseInt(br.readLine());	// 테스트 케이스 넘버
			String keyword = br.readLine();				// 키워드 입력
			String text = br.readLine();				// 텍스트 입력
			
			int klen = keyword.length();	// 키워드 길이
			int tlen = text.length();		// 텍스트 길이
			int cnt = 0;					// 문자열 갯수		
			for(int i = 0 ;i<tlen-klen+1;i++) {	// i를 텍스트 길이에서 키워드 길이 뺀 수까지 반복문
				int len = 0;				// 같은 문자열 길이
				for(int j = 0 ; j<klen;j++) {	// 키워드 한글자 한글자 맞는지 반복문
					if(text.charAt(i+j)==keyword.charAt(j)) {	// 키워드 한글자랑 텍스트 한글자 같다면
						len++;					// 같은 문잘열 길이 하나 증가
					} else {
						break;
					}
				}
				if(len == klen) {			// 키워드의 길이랑 같다면 키워드가 해당 문자열에 있음
					cnt++;					// 문자열 갯수 하나 증가
				}
			}
			sb.append("#"+T+" "+cnt+"\n");	// sb에 출력할 답 저장
		}
		System.out.print(sb);				// sb 출력
    } // end of main
} // end of case
