import java.util.*;

class Solution {
    public List<Integer> solution(int[] fees, String[] records) {
        List<Integer> answer = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        TreeMap<String,Integer> result = new TreeMap<>();
        int lastTime = 23*60+59;
        for(String rec : records){
            String[] s = rec.split(" ");
            String[] t = s[0].split(":");
            int time = 60*(Integer.parseInt(t[0]))+Integer.parseInt(t[1]);
            
            if(s[2].equals("IN")){
                map.put(s[1],time);
            } else if(s[2].equals("OUT")){
                int inTime = map.get(s[1]);
                map.put(s[1],-1);
                result.put(s[1],result.getOrDefault(s[1], 0) + (time - inTime));
            } 
        }
        
        for(String s : map.keySet()){
            if(map.get(s)!=-1){
                int t = lastTime-map.get(s);
                result.put(s,result.getOrDefault(s, 0) +t);
            }
        }
        
        
        for(String s : result.keySet()){
            answer.add(calFee(result.get(s),fees[0],fees[1],fees[2],fees[3]));
        }
        
        return answer;
    }
    
    static int calFee(int n, int bTime, int bFee, int time, int tFee){
        if(n-bTime<=0){
            return bFee;
        }
        return bFee + (int) Math.ceil((n - bTime) / (double) time) * tFee;
    }
}