import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = -1;
        long total = 0;
        long q1_sum = 0;
        Queue<Integer> q1 = new ArrayDeque<>();
        Queue<Integer> q2 = new ArrayDeque<>();
        
        for(int i = 0 ;i<queue1.length;i++){
            q1.add(queue1[i]);
            q2.add(queue2[i]);
            total+=(queue1[i]+queue2[i]);
            q1_sum+=queue1[i];
        }
        
        if(total%2 == 1) return answer;
        
        long target = total/2;
        answer = 0;
        while(true){
            if(answer>(queue1.length+queue2.length)*2) return -1;
            if(q1_sum == target)break;
            if(q1_sum>target){
                int cur = q1.poll();
                q1_sum-=cur;
                q2.add(cur);
            } else{
                int cur = q2.poll();
                q1_sum+=cur;
                q1.add(cur);    
            }
            answer++;

        }
        
        return answer;
    }
}