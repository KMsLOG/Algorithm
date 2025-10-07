class Solution {
    static int[] discounts = {10, 20, 30, 40};
    static int max_users = 0;
    static int max_cost = 0;
    
    public int[] solution(int[][] users, int[] emoticons) {
        int[] answer = new int[2];

        dfs(users, emoticons, 0, new int[emoticons.length]);
        
        answer[0] = max_users;
        answer[1] = max_cost;
        return answer;
    }
    
    static void dfs(int[][] users, int[] emoticons, int depth, int[] dis) {
        if(depth == emoticons.length) {
            int total_cost = 0; 
            int total_cnt = 0; 
            int[] dis_emo = new int[emoticons.length];
            for(int i = 0; i < emoticons.length; i++) {
                dis_emo[i] = emoticons[i] * (100 - dis[i]) / 100;
            }
            

            for(int i = 0; i < users.length; i++) {
                int[] user = users[i];
                int ratio = user[0];
                int cost = user[1];
                int sum = 0;
                
                for(int j = 0; j < emoticons.length; j++) {
                    if(dis[j] >= ratio) { 
                        sum += dis_emo[j];
                    }
                }
                
                if(sum >= cost) {
                    total_cnt++;
                } else {
                    total_cost += sum;
                }
            }
            
            if(total_cnt > max_users) {
                max_users = total_cnt;
                max_cost = total_cost;
            } else if(total_cnt == max_users && total_cost > max_cost) {
                max_cost = total_cost;
            }
            
            return;
        }
        
        for(int i = 0; i < discounts.length; i++) {
            dis[depth] = discounts[i];
            dfs(users, emoticons, depth + 1, dis);
        }
    }
}