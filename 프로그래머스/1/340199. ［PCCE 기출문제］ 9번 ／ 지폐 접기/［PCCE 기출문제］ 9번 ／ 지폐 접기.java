import java.util.*;

class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        while(!check(wallet,bill)){
            answer++;
            if(bill[0]>=bill[1]){
                bill[0] = bill[0]/2;
            } else{
                bill[1] = bill[1]/2;
            }
        }
        return answer;
    }
    static boolean check(int[] wallet, int[] bill){
        if((wallet[0]>=bill[0]&&wallet[1]>=bill[1]) || (wallet[0]>=bill[1]&&wallet[1]>=bill[0])) return true;
        return false;
    }
}