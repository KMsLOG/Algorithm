import java.util.*;

class Solution {
    public int solution(int n, int w, int num) {
        int answer = 0;
        int targetQ = (num - 1) / w + 1;
        int targetR;
        if (targetQ % 2 != 0) {
            targetR = (num - 1) % w + 1;
        } else {
            targetR = w - ((num - 1) % w);
        }

        int endQ = (n - 1) / w + 1;
        int endR;
        if (endQ % 2 != 0) {
            endR = (n - 1) % w + 1;
        } else {
            endR = w - ((n - 1) % w);
        }
        
        answer = endQ - targetQ + 1;
        
        if (endQ % 2 != 0) {
            if (targetR > endR) {
                answer--;
            }
        } else {
            if (targetR < endR) {
                answer--; 
            }
        }

        return answer;
    }
}