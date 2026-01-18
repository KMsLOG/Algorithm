import java.util.*;

class Solution {
    public int solution(int[] mats, String[][] park) {
        int N = park.length;
        int M = park[0].length;
        
        Arrays.sort(mats);
        
        for (int idx = mats.length - 1; idx >= 0; idx--) {
            int size = mats[idx];
            for(int i = 0 ;i<=N-size;i++){
                for(int j = 0 ;j<=M-size;j++){
                    if(check(i,j,size,park)) return size;
                }
            }
        }
        
        return -1;
    }
    
    static boolean check(int r, int c, int size, String[][] park){
        for(int i = r ; i<r+size; i++){
            for(int j = c ; j<c+size;j++){
                if(!park[i][j].equals("-1")) return false;
            }
        }
        return true;
    }
}