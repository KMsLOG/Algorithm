import java.util.*;

class Solution {
    static int N,M;
    static Map<Integer,Integer> map = new HashMap<>();
    static int[][] group,gLand;
    static int[] dr = {0,0,-1,1};
    static int[] dc = {1,-1,0,0};
    public int solution(int[][] land) {
        int answer = 0;
        N = land.length;
		M = land[0].length;
		group = new int[N][M];
		gLand = land;
        int groupId = 0;
        for(int i = 0 ;i<N;i++){
            for(int j = 0 ; j<M ;j++){
                if(group[i][j] ==0 && gLand[i][j]==1){
                    groupId++;
                    bfs(i,j,groupId);
                }
            }
        }
        
        for(int j = 0 ;j<M;j++){
            int sum = 0;
            Set<Integer> set = new HashSet<>();
            for(int i = 0 ;i<N;i++){
                if(group[i][j]>0){
                    set.add(group[i][j]);
                }
            }
            
            for(int gId : set){
                sum+=map.get(gId);
            }
            answer = Math.max(answer,sum);
        }
        
        return answer;
    }
    
    static void bfs(int r, int c, int groupId){
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{r,c});
        group[r][c] = groupId;
        int cnt = 1;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            for(int d = 0 ;d<4;d++){
                int nr = cur[0]+dr[d];
                int nc = cur[1]+dc[d];
                
                if(nr<0 || nr>=N || nc<0 || nc>= M) continue;
                
                if(group[nr][nc] == 0 && gLand[nr][nc]==1){
                    group[nr][nc] = groupId;
                    q.add(new int[]{nr,nc});
                    cnt++;
                }
            }
        }
        map.put(groupId,cnt);
    } // end of bfs
}