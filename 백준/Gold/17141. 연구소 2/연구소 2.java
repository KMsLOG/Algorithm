import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class Virus {
    int r;
    int c;

    public Virus(int r, int c) {
        this.r = r;
        this.c = c;
    }
}

public class Main {
    static int N, M;
    static int[][] map;
    static List<Virus> avail;
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        avail = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    avail.add(new Virus(i, j)); // 바이러스 가능한 곳
                }
            }
        }

        List<Virus> virus = new ArrayList<>(); // 바이러스 놓을 곳
        comb(0, virus, M);
        
        if (min == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(min);
        }
    } // end of main

    static void comb(int start, List<Virus> virus, int r) {
        if (r == 0) {
            int[][] copyMap = new int[N][N];
            for (int i = 0; i < N; i++) {
                System.arraycopy(map[i], 0, copyMap[i], 0, N);
            }

            boolean[][] visited = new boolean[N][N];
            Queue<Virus> q = new LinkedList<>();
            for (Virus v : virus) {
                q.add(v);
                visited[v.r][v.c] = true;
            }

            int time = bfs(q, copyMap, visited);
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (copyMap[i][j] == 0) { // 빈 칸이 남아있는 경우
                        time =  Integer.MAX_VALUE;
                    }
                }
            }
            
            
            min = Math.min(min, time);
            return;
        }

        for (int i = start; i < avail.size(); i++) {
            virus.add(avail.get(i));
            comb(i + 1, virus, r - 1);
            virus.remove(virus.size() - 1);
        }
    } // end of comb

    static int bfs(Queue<Virus> q, int[][] copyMap, boolean[][] visited) {
        int time = 0;

        while (!q.isEmpty()) {
            int qSize = q.size();
            for (int i = 0; i < qSize; i++) {
                Virus cur = q.poll();

                for (int d = 0; d < 4; d++) {
                    int nr = cur.r + dr[d];
                    int nc = cur.c + dc[d];
                    try {
                    	if(!visited[nr][nc] && copyMap[nr][nc] != 1) {
                            visited[nr][nc] = true;
                            copyMap[nr][nc] = 2; // 바이러스 전파
                            q.add(new Virus(nr, nc));
                        }
					} catch (Exception e) {}
                }
            }
            time++;
        }
        
        for(int i = 0 ;i<N;i++) {
        	for(int j = 0 ;j<N;j++) {
        		if(copyMap[i][j]==2 && !visited[i][j]) {
        			copyMap[i][j] = 0;
        		}
        	}
        }
        return time - 1; 
    } // end of bfs
} // end of class
