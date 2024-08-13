import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;


public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for(int tc =1; tc<=10;tc++) {
			int N = Integer.parseInt(br.readLine()); // 원본 암호문 뭉치 속 암호문의 개수
			List<Integer> code = new LinkedList<>(); // 암호문을 리스트로 설정
			String s = br.readLine();
			StringTokenizer st = new StringTokenizer(s);
			for(int i = 0 ; i<N;i++) {	// 암호문 리스트에 암호문 넣기
				code.add(Integer.parseInt(st.nextToken()));
			}
			int M = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for(int i = 0 ; i<M;i++) {
				String order = st.nextToken();
				if(order.equals("I")) {	// 삽입하는 경우
					insert(code, st);	// 삽입 메서드 실행
				} else if(order.equals("D")) {	// 삭제하는 경우
					delete(code, st);			// 삭제 메서드 실행
				} else if(order.equals("A")) {	// 추가하는 경우
					add(code, st);				// 추가 메서드 실행
				}
			}
			sb.append("#"+tc+" ");	// tc번호 입력
			for(int i = 0 ; i<10;i++) {	// 상위 10개 암호문만
				sb.append(code.get(i)+" ");	// 암호문 입력
			}
			sb.append("\n");	// 행바꾸기
		} // end of tc
		System.out.print(sb);	// 출력
	} // end of main
	
	// 삽입하기 메서드
	static void insert(List<Integer> list,StringTokenizer st) {
		int x = Integer.parseInt(st.nextToken());	// x번째 암호문 인덱스
		int y = Integer.parseInt(st.nextToken());	// y개
		for(int i = 0; i<y;i++) {
			list.add(x+i, Integer.parseInt(st.nextToken())); // 암호문 삽입
		}
	}
	
	// 삭제하기 메서드
	static void delete(List<Integer> list,StringTokenizer st) {
		int x = Integer.parseInt(st.nextToken());	// x번째 암호문 인덱스
		int y = Integer.parseInt(st.nextToken());	// y개
		
		for(int i = 0 ; i <y;i++ ) {
			list.remove(x);	// 삭제하기
		}
	}
	
	// 추가하기 메서드
	static void add(List<Integer> list,StringTokenizer st) {
		int y = Integer.parseInt(st.nextToken());	// y개
		
		for(int i = 0 ; i<y ;i++) {
			list.add(Integer.parseInt(st.nextToken()));	// 맨 뒤에 암호문 추가하기
		}
	}
} // end of class
