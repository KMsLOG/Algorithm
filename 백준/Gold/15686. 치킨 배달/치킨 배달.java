import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Chicken{
	int r;
	int c;
	public Chicken(int r, int c) {
		this.r = r;
		this.c = c;
	}
}

public class Main {
	
	static int minCnt = Integer.MAX_VALUE; // 최소 치킨 거리
	static int cnt = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // N 크기
		int M = Integer.parseInt(st.nextToken()); // 남아있어야하는 치킨집 개수
		
		
		
		int[][] map = new int[N][N];
		List<Chicken> chicken = new ArrayList<>(); // 치킨집을 저장할 리스트
		List<Chicken> house = new ArrayList<>(); // 집을 저장할 리스트
		
		for(int i = 0 ; i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==2) { // 행열 값이 2이면
					chicken.add(new Chicken(i,j)); // 치킨집 리스트에 좌표 저장
				} else if(map[i][j] == 1) { // 행열 값이 1이면
					house.add(new Chicken(i,j)); // 집 리스트에 좌표 저장
				}
			}
		}
		
		
		boolean[] visited = new boolean[chicken.size()]; // 치킨집 방문 표시할 visited
		comb(house,chicken,visited,0,M);
		System.out.println(minCnt);
		
	} // end of main
	
	// 조합으로 치킨집 뽑기
	static void comb(List<Chicken> house,List<Chicken> chicken,boolean[] visited, int start, int m) {
		if(m == 0) {
			count(house,chicken,visited); // 조합으로 살아남은 치킨집에서 치킨거리 구하기
			if(minCnt>cnt) {
				minCnt = cnt;
			}
			cnt = 0;
			return;
		} else {
			for(int i = start;i<chicken.size();i++) {
				visited[i] = true;
				comb(house, chicken,visited, i + 1, m-1);
				visited[i] = false;
				}
			}
		} // end of comb
	static void count (List<Chicken> house, List<Chicken> chicken, boolean[] visited) {
		List<Chicken> lastChicken = new ArrayList<>(); // 살아남은 치킨집 리스트
		for(int i = 0 ; i<chicken.size();i++) {
			if(visited[i]==true) {
				lastChicken.add(chicken.get(i));
			}
		}
		
		for(int i = 0 ; i<house.size();i++) { // 집마다 최소 치킨거리 구하기
			int dis = 0;
			int mindis = Integer.MAX_VALUE;
			for(int j = 0 ; j<lastChicken.size();j++) {
				dis = Math.abs(house.get(i).r - lastChicken.get(j).r) + Math.abs(house.get(i).c - lastChicken.get(j).c);
				if(mindis > dis) {
					mindis = dis;
				}
			}
			cnt+=mindis;
			if(cnt>minCnt) {
				return;
			}
		}
	} // end of count
	
} // end of class