import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        int N = players.length;
        String[] answer = new String[N];
        
        Map<String,Integer> map = new HashMap<>();
        
        for(int i = 0 ;i<N ;i++){
            answer[i] = players[i];
            map.put(answer[i],i);
        }
        
        for(String call : callings){
            int idx = map.get(call);
            int preIdx = idx-1;
            
            String prePlayer = answer[preIdx];
            
            answer[preIdx] = call;
            answer[idx] = prePlayer;
            
            map.put(call,preIdx);
            map.put(prePlayer,idx);
        }
        
        
        return answer;
    }
}