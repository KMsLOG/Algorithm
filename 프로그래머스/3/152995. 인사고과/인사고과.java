import java.util.*;

class Solution {
    public int solution(int[][] scores) {
        int wan_sc1 = scores[0][0];
        int wan_sc2 = scores[0][1];
        int wanSum = wan_sc1 + wan_sc2;
        
        Arrays.sort(scores, (a, b) -> {
            if(a[0] == b[0]) return a[1]-b[1];
            return b[0] - a[0];
        });
        
        int maxScore2 = 0;
        int answer = 1;
        
        for(int[] score : scores){
            int sc1 = score[0];
            int sc2 = score[1];
            
            if(sc2 < maxScore2){
                if(sc1 == wan_sc1 && sc2 == wan_sc2){
                    return -1;
                }
                continue;
            }
            
            maxScore2 = Math.max(maxScore2, sc2);
            
            if(sc1 + sc2 > wanSum){
                answer++;
            }
        }
        
        return answer;
    }
}