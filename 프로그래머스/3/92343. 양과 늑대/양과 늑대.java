import java.util.*;

class Solution {
    static int answer = 0;

    public int solution(int[] info, int[][] edges) {
        
        dfs(0,new boolean[info.length],0,0,info,edges);
        

        return answer;
    }

    static void dfs(int idx, boolean[] visited, int sheep, int wolf, int[] info, int[][] edges){
        visited[idx] = true;
        if(info[idx] == 0){
            sheep++;
        } else{
            wolf++;
        }
        if(answer<sheep){
            answer = sheep;
        }
        
        if(wolf>=sheep) return;
        
        for(int[] edge : edges){
            if(visited[edge[0]] && !visited[edge[1]]){
                boolean[] nextVisited = new boolean[info.length];
                for(int i = 0 ; i<info.length;i++){
                    nextVisited[i] = visited[i];
                }
                dfs(edge[1],nextVisited,sheep,wolf,info,edges);
            }
        }
    }
}