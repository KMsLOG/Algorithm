import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] dr = {0, 1, 0, -1}; // 좌 하 우 상
    static int[] dc = {-1, 0, 1, 0};
    static double[] per = {0.01,0.01,0.02,0.02,0.07,0.07,0.1,0.1,0.05,0};
    static int[][] sandR = {
            {-1,1,-2,2,-1,1,-1,1,0,0}, // 좌 
            {-1,-1,0,0,0,0,1,1,2,1}, // 하 
            {-1,1,-2,2,-1,1,-1,1,0,0}, // 우
            {1,1,0,0,0,0,-1,-1,-2,-1}, // 상 
    };
    static int[][] sandC = {
            {1,1,0,0,0,0,-1,-1,-2,-1}, // 좌 
            {-1,1,-2,2,-1,1,-1,1,0,0}, // 하 
            {-1,-1,0,0,0,0,1,1,2,1}, // 우
            {-1,1,-2,2,-1,1,-1,1,0,0}, // 상 
    };
    
    static int[][] map;
    static int N;
    static int cnt = 0;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        int r = N/2;
        int c = N/2;
        
        int[] direction = {1, 1, 2, 2};
        double sand;
        
        sand : while (true) {
        	
            for (int d=0; d<4; d++) {
                for (int i=0; i<direction[d]; i++) {
                    r += dr[d];
                    c += dc[d];
                    
                    sand = map[r][c]; 
                
                    if (sand > 0) {
                        sandMove(r, c, d, sand);
                    }
                    
                    if (r == 0 && c == 0) {
                    	System.out.println(cnt);
                        break sand;
                    }
                }
            }
            
            for (int k=0; k<4; k++) {
                direction[k] += 2;
            }
        }
        
    }
    

    
    public static void sandMove(int r, int c, int d, double initSand) {
        int nr, nc;
        double moveSand = 0; 
        
        map[r][c] = 0;
        
        for(int i=0; i<10; i++) {
            nr = r + sandR[d][i];
            nc = c + sandC[d][i];
            
            int sand = (int) Math.floor(initSand* per[i]);
            
            if (i == 9) {
               
                double aSand = initSand - moveSand;
                
                if (nr<0 || nr>=N || nc<0 || nc>=N) {
                    cnt += aSand;
                } else {
                    map[nr][nc] += aSand;
                }
            } else {
                if (nr<0 || nr>=N || nc<0 || nc>=N) {
                    cnt += sand;
                } else {
                    map[nr][nc] += sand; 
                }
                moveSand += sand;
            }
            
        }
    } // end of sandMove
} // end of class