import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        int N = friends.length;
        int[][] map = new int[N][N]; // 주고 받은 맵
        int[] vec = new int[N]; // 선물지수
        HashMap<String,Integer> f = new HashMap<>();
        
        for(int i = 0 ; i<friends.length ; i++){
            f.put(friends[i],i);
        }
        
        // 주고 받은 맵 값 넣기
        for(String g:gifts){
            String[] spl = g.split(" ");
            int r = f.get(spl[0]);
            int c = f.get(spl[1]);
            map[r][c]++;
        }
        
        // 선물 지수 구하기
        for(int i = 0 ; i<N ;i++){
            int give = 0;
            int take = 0;
            for(int j = 0 ;j<N ;j++){
                give+=map[i][j];
                take+=map[j][i];
            }
            
            vec[i] = give-take;
        }
        
        for(int i = 0 ;i<N ;i++){
            int result = 0;
            for(int j = 0 ;j<N;j++){
                if(i==j) continue;
                if(map[i][j]>map[j][i]){
                    result++;
                } else if((map[i][j]==0 && map[j][i]==0) || map[i][j]==map[j][i]){
                    if(vec[i]>vec[j]){
                        result++;
                    }
                }
            }
            if(answer<result){
                answer = result;
            }
        }
        return answer;
    }
}