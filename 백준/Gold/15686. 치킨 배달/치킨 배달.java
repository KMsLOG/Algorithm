import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
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
	
	static int minCnt = Integer.MAX_VALUE;
	static int cnt = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		
		
		int[][] map = new int[N][N];
		List<Chicken> chicken = new ArrayList<>();
		List<Chicken> house = new ArrayList<>();
		
		for(int i = 0 ; i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==2) {
					chicken.add(new Chicken(i,j));
				} else if(map[i][j] == 1) {
					house.add(new Chicken(i,j));
				}
			}
		}
		
		
		boolean[] visited = new boolean[chicken.size()];
		comb(house,chicken,visited,0,M);
		System.out.println(minCnt);
		
	} // end of main
	
	static void comb(List<Chicken> house,List<Chicken> chicken,boolean[] visited, int start, int m) {
		if(m == 0) {
			count(house,chicken,visited);
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
		List<Chicken> lastChicken = new ArrayList<>();;
		for(int i = 0 ; i<chicken.size();i++) {
			if(visited[i]==true) {
				lastChicken.add(chicken.get(i));
			}
		}
		
		for(int i = 0 ; i<house.size();i++) {
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
