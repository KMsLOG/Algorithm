import java.util.*;

class Solution {
    static String[] userIds;
    static String[] bannedIds;
    static Set<Set<String>> bannedSet;
    public int solution(String[] user_id, String[] banned_id) {
        userIds = user_id;
        bannedIds = banned_id;
        bannedSet = new HashSet<>();
        dfs(0,new HashSet<>());
        
        return bannedSet.size();
    }
    
    static void dfs(int depth, Set<String> set){
        if(depth == bannedIds.length){
            bannedSet.add(set);
            return;
        }
        
        for(int i = 0 ; i<userIds.length; i++){
            if(set.contains(userIds[i])) continue;
            if(find(userIds[i],bannedIds[depth])){
                set.add(userIds[i]);
                dfs(depth+1, new HashSet<>(set));
                set.remove(userIds[i]);
            }
            
        }
    }
    
    static boolean find(String userId, String bannedId){
        if(userId.length() != bannedId.length()) return false;
        
        for(int i = 0 ;i<userId.length(); i++){
            if(bannedId.charAt(i)!='*' && bannedId.charAt(i) !=userId.charAt(i)){
                return false;
            }
        }
        
        return true;
    }
}