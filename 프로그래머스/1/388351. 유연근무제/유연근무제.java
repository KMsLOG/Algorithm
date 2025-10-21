import java.util.*;

class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        
        for(int i = 0 ; i<schedules.length ; i++){
            int emp_sch = schedules[i];
            int[] emp_log = timelogs[i];
            
            if(check(emp_sch, emp_log, startday)) answer++;
            
        }
        
        return answer;
    }
    
    static boolean check(int emp_sch, int[] emp_log, int startday){
        int idx = 0;
        int start = startday;
        int ok_time = emp_sch+10;
        
        if((emp_sch+10)%100>=60){
            ok_time = (emp_sch/100+1)*100 + ((emp_sch+10)%100)%60;
        }
        
        
        
        while(idx<7){
            
            if(emp_log[idx]>ok_time && start<6) return false;
            
            start++;
            if(start>7) start = 1;
            idx++;
        }
        
        return true;
    }
}