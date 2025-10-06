import java.util.*;

class Solution {
    
    static int N = 1000000;
    
    public int[] solution(int[][] edges) {
        int[] answer = new int[4];
        int[] out = new int[N+1];
        int[] in = new int[N+1];
        
        // 인, 아웃 값 넣기
        for(int[] e : edges){
            out[e[0]]++;
            in[e[1]]++;
        }
        
        int root = -1;
        int stick = 0;
        int eight = 0;
        
        // 판별하기
        for(int i = 1; i<N ;i++){
            if(out[i]>=2){
                if(in[i]==0){
                    root = i;
                } else{
                    eight++;
                }
            } else if(in[i]>=1 && out[i]==0){
                stick++;
            }
        }
        
        answer[0] = root;
        answer[1] = out[root]-stick-eight;
        answer[2] = stick;
        answer[3] = eight;
        
        return answer;
    }
}