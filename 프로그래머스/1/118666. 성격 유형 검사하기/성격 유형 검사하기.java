import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        char[][] per = new char[][]{{'R','T'},{'C','F'},{'J','M'},{'A','N'}};
        Map<Character,Integer> map = new HashMap<>();
        
        for(char[] p : per){
            map.put(p[0],0);
            map.put(p[1],0);
        }
        
        for(int i = 0 ; i<choices.length;i++){
            int choice = choices[i];
            char first = survey[i].charAt(0);
            char second = survey[i].charAt(1);
            if(choice<4){
                map.put(first, map.get(first) + (4-choice));
            } else if(choice>4){
                map.put(second,map.get(second)+(choice-4));
            }
        }
        
        for(int i = 0 ;i<4 ;i++){
            if(map.get(per[i][0])>=map.get(per[i][1])){
                answer = answer+per[i][0];
            } else {
                answer = answer+per[i][1];
            }
        }
        
        return answer;
    }
}