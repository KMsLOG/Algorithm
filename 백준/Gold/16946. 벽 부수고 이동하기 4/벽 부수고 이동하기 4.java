import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int N,M;
    static int[][] map;
    static boolean[][] visited;
    static int[][] group;
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};
    static Map<Integer,Integer> gSize = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        group = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            char[] row = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                map[i][j] = row[j] - '0';
            }
        }

        int idx = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j] && map[i][j] == 0) {
                    int size = bfs(i, j, idx);
                    gSize.put(idx, size);
                    idx++;
                }
            }
        }


        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<N;i++){
            for(int j = 0 ; j<M;j++){
                if (map[i][j] == 1) {
                    Set<Integer> nearGroups = new HashSet<>();
                    int sum = 1;

                    for (int d = 0; d < 4; d++) {
                        int nr = i + dr[d];
                        int nc = j + dc[d];
                        if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
                        if (map[nr][nc] == 0) {
                            int gIdx = group[nr][nc];
                            if (nearGroups.add(gIdx)) {
                                sum += gSize.get(gIdx);
                            }
                        }
                    }
                    sb.append(sum % 10);
                } else {
                    sb.append(0);
                }

            }
            sb.append("\n");
        }
        System.out.println(sb);
    } // end of main
    static int bfs(int startR, int startC, int idx){
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{startR,startC});
        visited[startR][startC] = true;
        group[startR][startC] = idx;
        int cnt = 1;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];

            for(int d = 0 ; d<4;d++){
                int nr = r + dr[d];
                int nc = c + dc[d];

                if(nr<0||nr>=N||nc<0||nc>=M) continue;

                if(map[nr][nc]==0 && !visited[nr][nc]){
                    visited[nr][nc] = true;
                    group[nr][nc] = idx;
                    q.add(new int[]{nr,nc});
                    cnt++;
                }
            }
        }
        return cnt;
    } // end of bfs
}
