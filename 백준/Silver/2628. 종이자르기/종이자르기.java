import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] nm = br.readLine().split(" ");
		int N = Integer.parseInt(nm[0]); // 가로 길이
		int M = Integer.parseInt(nm[1]); // 세로 길이
		int t = Integer.parseInt(br.readLine()); // 종이 자르는 횟수
		List<Integer> vertical = new ArrayList<>(); // 세로로 자르는 곳 리스트
		vertical.add(0);
		vertical.add(N);
		List<Integer> horizon = new ArrayList<>(); // 가로로 자르는 곳 리스트
		horizon.add(0);
		horizon.add(M);
		List<Integer> verticaleachdistance = new ArrayList<>(); // 세로로 잘라진 길이 리스트
		List<Integer> horizoneachdistance = new ArrayList<>(); // 세로로 잘라진 길이 리스트
		
		for(int i = 0 ; i<t;i++) {
			String s = br.readLine();
			StringTokenizer st = new StringTokenizer(s);
			int sd = Integer.parseInt(st.nextToken()); // 판단기준 0 or 1
			int line = Integer.parseInt(st.nextToken()); // 자르는 곳
			if(sd == 0) { // 가로로 자르기
				horizon.add(line);
			} else { // 세로로 자르기
				vertical.add(line);
			}
		}
		// 각각 리스트 오름차순 정렬
		Collections.sort(vertical);
		Collections.sort(horizon);
		
		// 잘라진 길이 리스트 만들기
		for(int i = 1 ; i<vertical.size();i++) {
			verticaleachdistance.add(vertical.get(i)-vertical.get(i-1));
		}
		for(int i = 1 ; i<horizon.size();i++) {
			horizoneachdistance.add(horizon.get(i)-horizon.get(i-1));
		}
		
		// 각각 리스트 오름차순 정렬
		Collections.sort(verticaleachdistance);
		Collections.sort(horizoneachdistance);
		
		System.out.println(verticaleachdistance.get(verticaleachdistance.size()-1)*horizoneachdistance.get(horizoneachdistance.size()-1));
		
	} // end of main
}// end of class
