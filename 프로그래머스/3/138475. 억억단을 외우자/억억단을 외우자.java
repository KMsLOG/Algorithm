import java.util.*;

class Solution {
    public List<Integer> solution(int e, int[] starts) {
        List<Integer> answer = new ArrayList<>();
        int[] arr = new int[e + 1];

        for (int i = 1; i <= e; i++) {
            for (int j = i; j <= e; j += i) {
                arr[j]++;
            }
        }


        int[] maxNum = new int[e + 1];
        int maxIdx = e;
        for (int i = e; i >= 1; i--) {
            if (arr[i] >= arr[maxIdx]) {
                maxIdx = i; 
            }
            maxNum[i] = maxIdx;
        }

        for (int start : starts) {
            answer.add(maxNum[start]);
        }

        return answer;
    }
}
