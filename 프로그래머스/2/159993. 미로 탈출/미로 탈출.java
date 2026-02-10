import java.util.*;

class Solution {
    static int[] dr = {0,0,-1,1};
    static int[] dc = {1,-1,0,0};
    static int N,M,r,c;
    public int solution(String[] maps) {
        int answer = 0;
        N = maps.length;
        M = maps[0].length();
        
        r = -1;
        c = -1;
        
        for(int i = 0 ;i<N ;i++){
            for(int j = 0 ; j<M ;j++){
                char start = maps[i].charAt(j);
                if(start == 'S'){
                    r = i;
                    c = j;
                    break;
                }
            }
        }
        
        int cntL = bfs(maps,new int[N][M], new boolean[N][M], 'L');
        if(cntL == -1) return -1;
        
        int cntE = bfs(maps,new int[N][M], new boolean[N][M], 'E');
        if(cntE == -1) return -1;
        
        
        return cntL + cntE;
    }
    
    static int bfs(String[] maps, int[][] cnt, boolean[][] visited, char target){
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{r,c});
        visited[r][c] = true;
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            r = cur[0];
            c = cur[1];
            
            if(maps[r].charAt(c) == target){
                return cnt[r][c];
            }
            
            for(int d = 0 ; d<4 ; d++){
                int nr = r + dr[d];
                int nc = c + dc[d];
                
                if(nr<0 || nr>=N || nc<0 || nc>=M || maps[nr].charAt(nc) == 'X') continue;
                if(!visited[nr][nc]){
                    q.add(new int[]{nr,nc});
                    visited[nr][nc] = true;
                    cnt[nr][nc] = cnt[r][c]+1;
                }
            }
        }
        
        return -1;
    }
}