import java.util.*;

class Solution {
    static int[] dr = {0,0,-1,1};
    static int[] dc = {1,-1,0,0};
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        String find = board[h][w];
        int n = board.length;
        int m = board[0].length;
        for(int d = 0 ; d<4 ; d++){
            int nr = h + dr[d];
            int nc = w + dc[d];
            
            if(nr<0 || nr>=n || nc<0 || nc>=m) continue;
            
            if(board[nr][nc].equals(find)) answer++;
        }
        return answer;
    }
}