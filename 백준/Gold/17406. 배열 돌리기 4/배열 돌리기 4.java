import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int R,C,K;
	static int[][] map;
	static int[][] rotate;
	static int[] dr = {0,1,0,-1}; // 오른 아래 왼 위
	static int[] dc = {1,0,-1,0};
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[R][C];
		
		for(int i = 0 ;i<R;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ;j<C;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		rotate = new int[K][3];
		
		
		
		for(int i = 0 ; i<K;i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int[] g = {r,c,s};
			rotate[i] = g;
		}
		int[][] output = new int[K][3];
		boolean[] visited = new boolean[K];
		perm(rotate,output,visited,0,K,K);
		
		System.out.println(min);
	} // end of main
	
	
	static void perm(int[][] rotate, int[][] output, boolean[] visited, int depth, int n, int r) {
        if (depth == r) {
        	findMin(output);
        	
            return;
        }

        for (int i = 0; i < n; i++) {
            if (visited[i] != true) {
                visited[i] = true;
                output[depth] = rotate[i];
                perm(rotate, output, visited, depth + 1, n, r);
                visited[i] = false;
            }
        }
    } // end of perm
	
	
	static void findMin(int[][] output) {
		int[][] copyMap = new int[R][C];
		for(int i = 0 ;i<R;i++) {
			System.arraycopy(map[i], 0, copyMap[i], 0, C);
		}
		
		// 순열에서 각각 뽑아와서 돌려돌려
		for(int[] arr : output) {
			int r = arr[0]-1;
			int c = arr[1]-1;
			int ee = arr[2];
			
			for(int s = 1 ; s<=ee;s++) {
				rotate(copyMap,r,c,s);
			}
		}
		
		for(int i = 0 ; i<R;i++) {
			int sum = 0;
			for(int j = 0 ; j<C;j++) {
				sum+=copyMap[i][j];
			}
			
			min = Math.min(min, sum);
		}
		
		
		
	} // end of mapRotate
	
	static void rotate(int[][ ]arr,int r, int c, int s) {
		int nr = -1;
		int nc = -1;
		int d = 0;
		int limit_x1 = r-s;
		int limit_y1 = c-s;
		int limit_x2 = r+s;
		int limit_y2 = c+s;
		r = r-s;
		c = c-s;
		int temp = arr[r][c];
		int temp2 = 0;
		while(nr!=limit_x1|| nc!=limit_y1) {
			nr = r + dr[d];	// 방향에 맞는 새로운 행 위치
			nc = c + dc[d];	// 방향에 맞는 새로운 열 위치
			
			if(nr<limit_x1 || nr>limit_x2 || nc<limit_y1 || nc>limit_y2 ) { // 새로운 행 또는 새로운 열이 배열의 크기를 넘어가거나 새로운 위치의 값이 0이 아닌 경우
				d = (d+1)%4;	// 방향 바꾸기
			}
			r += dr[d];	// 행 위치를 새로운 행 위치로 바꾸기 
			c += dc[d];	// 열 위치를 새로운 열 위치로 바꾸기
			temp2 = arr[r][c];
			arr[r][c] = temp;
			temp = temp2;
		}
	}
} // end of class
