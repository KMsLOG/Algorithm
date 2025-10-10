import java.util.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        int[] report_cnt = new int[id_list.length];
        List<Integer>[] report_users = new ArrayList[id_list.length];
        Map<String, Integer> id_map = new HashMap<>();
        Set<String> dupl = new HashSet<>();
        
        for(int i = 0 ;i<id_list.length;i++){
            id_map.put(id_list[i],i);
            report_users[i] = new ArrayList<>();
        }
        
        for(String s : report){
            if(dupl.contains(s)) continue;
            String[] users = s.split(" ");
            int user1 = id_map.get(users[0]);
            int user2 = id_map.get(users[1]);
            
            dupl.add(s);
            report_cnt[user2]++;
            report_users[user2].add(user1);
        }
        
        for(int i = 0 ;i<id_list.length;i++){
            if(report_cnt[i]>=k){
                for(int user : report_users[i]){
                    answer[user]++;
                }
            }
        }
        
        return answer;
    }
}