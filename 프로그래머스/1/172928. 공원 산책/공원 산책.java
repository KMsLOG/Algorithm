import java.util.*;

class Solution {
    static int[] dr = {0,0,-1,1}; // 동 서 북 남
    static int[] dc = {1,-1,0,0};

    public int[] solution(String[] park, String[] routes) {
        int N = park.length;
        int M = park[0].length();

        Map<Character,Integer> dir = new HashMap<>();
        dir.put('E',0);
        dir.put('W',1);
        dir.put('N',2);
        dir.put('S',3);

        int r = 0, c = 0;

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(park[i].charAt(j)=='S'){
                    r=i; c=j;
                    break;
                }
            }
        }

        for(String s : routes){
            StringTokenizer st = new StringTokenizer(s);
            int d = dir.get(st.nextToken().charAt(0));
            int len = Integer.parseInt(st.nextToken());

            int nr = r;
            int nc = c;
            boolean canMove = true;

            for(int i=0;i<len;i++){
                nr += dr[d];
                nc += dc[d];

                if(nr<0 || nr>=N || nc<0 || nc>=M || park[nr].charAt(nc)=='X'){
                    canMove = false;
                    break;
                }
            }

            if(canMove){
                r = nr;
                c = nc;
            }
        }

        return new int[]{r,c};
    }
}
