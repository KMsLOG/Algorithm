import java.util.*;

class Solution {
    public String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();
        
        int[] left = {3,0};
        int[] right = {3,2};
        
        
        for(int num : numbers){
            if(num == 0 || num%3==2){
                int[] target = new int[2];
                
                if(num == 0){
                    target[0] = 3;
                    target[1] = 1;
                } else{
                    target[0] = num/3;
                    target[1] = 1;
                }
                
                int leftLen = Math.abs(target[0]-left[0]) + Math.abs(target[1]-left[1]);
                int rightLen = Math.abs(target[0]-right[0]) + Math.abs(target[1]-right[1]);
                
                if(leftLen < rightLen){
                    left = target;
                    sb.append("L");
                } else if(rightLen < leftLen){
                    right = target;
                    sb.append("R");
                } else if(leftLen == rightLen){
                    if(hand.equals("left")){
                        left = target;
                        sb.append("L");
                    } else{
                        right = target;
                        sb.append("R");
                    }
                }
                
            } else if(num%3==1){
                sb.append("L");
                left[0] = num/3;
                left[1] = 0;
            } else if(num%3==0){
                sb.append("R");
                right[0] = num/3-1;
                right[1] = 2;
            }
        }
        
        
        return sb.toString();
    }
}