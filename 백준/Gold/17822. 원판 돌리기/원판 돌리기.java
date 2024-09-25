import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N,M,T;
	static int[][] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for(int i = 0 ; i<N ;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ;j<M ;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0 ; i<T ;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()); // 배수 x
			int d = Integer.parseInt(st.nextToken()); // 0->시계 / 1->반시계
			int k = Integer.parseInt(st.nextToken()); // k칸 회전
			
			for(int start = x ; start<=N ; start+=x) { // 원판 돌리기
				map[start-1] = rotate(start-1,d,k); 
			}
			find();
			
		}
		
		int sum = 0;
		for(int i = 0 ;i <N ;i++) {
			for(int j = 0 ;j<M ;j++) {
				sum+=map[i][j];
			}
		}
		
		
		System.out.println(sum);
		
	} // end of main
	
	// 원판 돌리기
	static int[] rotate(int start, int d ,int k) {
		int arr[] = new int[M];
		for(int j = 0 ; j<M ;j++) {
			if(d == 0) { // 시계 방향
				arr[j] = map[start][(j+M-k)%M];
			} else { // 반시계 방향
				arr[j] = map[start][(j+k)%M];
			}
		}
		
		return arr;
	} // end of rotate
	
	// 인접하고 같은 수 찾기
	
	static void find() {
		Queue<int[]> q = new ArrayDeque<>(); // 인접한 값이 같은 좌표 넣을 q
		int sum = 0;
		int cnt = 0;
		for(int i= 0 ; i<N ;i++) {
			for(int j = 0 ; j<M ;j++) {
				
				if(map[i][j] !=0) {
					sum+=map[i][j];
					cnt++;
				}
				
				if(j == 0 ) { // 원판 중 첫번쨰 값
					if(map[i][j]!=0 && (map[i][j] == map[i][M-1] || map[i][j] == map[i][1])) {
						q.add(new int[] {i,j});
						continue;
					}
				} else if (j==M-1){ // 원판 중 마지막 값
					if(map[i][j]!=0 && (map[i][j] == map[i][0] || map[i][j] == map[i][j-1])) {
						q.add(new int[] {i,j});
						continue;
					}
				} else { // 사이 값
					if(map[i][j]!=0 &&(map[i][j] == map[i][j+1] || map[i][j] == map[i][j-1])) {
						q.add(new int[] {i,j});
						continue;
					}
				}
				
				if(i==0) { // 첫번째 원판
					if(map[i][j]!=0 && map[i][j] == map[1][j]) {
						q.add(new int[] {i,j});
						continue;
					}
				} else if (i==N-1) { // 두번째 원판
					if(map[i][j]!=0 && map[i][j] == map[i-1][j]) {
						q.add(new int[] {i,j});
						continue;
					}
				} else { // 사이 원판
					if(map[i][j]!=0 &&(map[i][j] == map[i-1][j] || map[i][j]== map[i+1][j])) {
						q.add(new int[] {i,j});
						continue;
					}
				}
			}
		}
		
		if(q.isEmpty()) { // 인접한 값이 같은 좌표가 없으면
			double avg = (double) sum/cnt;
			for(int i = 0 ; i<N ;i++) {
				for(int j = 0 ;j<M ;j++) {
					if(map[i][j]>0) {
						if(map[i][j] > avg) {
							map[i][j] = map[i][j]-1;
						} else if(map[i][j] < avg) {
							map[i][j] = map[i][j]+1;
						}
					}
				}
			}
		} else { // 인접한 값이 같은 좌표가 있으면
			while(!q.isEmpty()) {
				int[] cur = q.poll();
				map[cur[0]][cur[1]] = 0;
			}
		}
		
	} // end of find
} // end of class
